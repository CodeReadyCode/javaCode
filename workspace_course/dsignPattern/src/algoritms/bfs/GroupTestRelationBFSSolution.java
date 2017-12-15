package algoritms.bfs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GroupTestRelationBFSSolution {

	static List<String> longerPath = new ArrayList<>();

	public static void main(String[] args) {

		// to find the most high relation between items
		//String[][] items = {{"item22"}, { "item1", "item3" }, { "item3", "item5"},{ "item4", "item3"},{ "item3", "item7"},{ "item9", "item10"},{ "item9", "item11"}};
				//{ "item6", "item1" } }; // 1,3,2,6,7 [, , , item3, item2]
		//String[][] items = {{"item22"}};
		String[][] items = { { "item1", "item3" }, { "item3", "item5"},{ "item5", "item1"}};


		HashSet<String> visited = new HashSet<>();
		Map<String, List<String>> map = new HashMap<>();

	//	int columns = items[0].length;
		int rows = items.length;

		populateRelationsForGraph(items, map, rows);
		Set<String> vertixs = map.keySet();
		Iterator<String> interator = vertixs.iterator();
		while(interator.hasNext()){
			dfs(interator.next(), map, visited);
			vertixs.removeAll(visited);  //remove visied vertix ( remove tree from grapth (map))
			visited.clear();
			interator = vertixs.iterator();
		}

		String[] result = longerPath.toArray(new String[0]);
		System.out.println(result);
	}

	private static void populateRelationsForGraph(String[][] itemAssociation, Map<String, List<String>> mapItemAssociation /*,int columns*/, int rows ) {
		for (int i = 0; i < rows; i++) {
			
			if(itemAssociation[i].length == 1){
				mapItemAssociation.put(itemAssociation[i][0],new ArrayList<>());
				continue;
			}
			
			List<String> list = new ArrayList<>();
			list.add(itemAssociation[i][1]);
			if (mapItemAssociation.get(itemAssociation[i][0]) != null) {
				List<String> temp = mapItemAssociation.get(itemAssociation[i][0]);
				list.addAll(temp);
			}
			mapItemAssociation.put(itemAssociation[i][0], list);
			
			list = new ArrayList<>();
			list.add(itemAssociation[i][0]);
			if (mapItemAssociation.get(itemAssociation[i][1]) != null) {
				List<String> temp = mapItemAssociation.get(itemAssociation[i][1]);
				list.addAll(temp);
			}
			mapItemAssociation.put(itemAssociation[i][1], list);
		}
	}

	private static void dfs(String v, Map<String, List<String>> map, HashSet<String> visited) {
		Stack<String> stack = new Stack<>();
		stack.add(v);
		while (!stack.isEmpty()) {
			String item = stack.pop();
			if (!visited.contains(item)) {
				visited.add(item);
			//	if (map.get(item) != null) {
					List<String> negs = map.get(item);
					for (String neg : negs) {
						stack.push(neg);
			//		}
				}

			}  

		}

		if (longerPath.size() < visited.size() ) {
			longerPath.clear();
			longerPath.addAll(visited);
		} else if (longerPath.size() == visited.size()) {
			List<String> convertedSetVisitedToLists = new ArrayList<>(visited);
			for (int i = 0; i < convertedSetVisitedToLists.size(); i++) {
				String visitedItem = convertedSetVisitedToLists.get(i);
				String longestItem = longerPath.get(i);
				if (visitedItem.compareTo(longestItem) < 0) {
					longerPath.clear();
					longerPath.addAll(visited);
					break;
				} 
			}
		}
	}
}
