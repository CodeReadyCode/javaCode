package a.solutions;
import java.util.*;

public class Solution
{ 
	
	
	List<String> longerPath =  new ArrayList<>();
	
	public String[] largestItemAssociation(String[][] itemAssociation)
	{
	  
	    Set<String> vertixes =  new HashSet<>();
	    Map<String,List<String>> mapItemAssociation = new HashMap<>();
	    
	    int columns = itemAssociation[0].length;
	    int rows = itemAssociation.length;
	    
	    for (int i = 0; i< rows; i++){
	        for(int j = 0; j< columns; j++){
	            vertixes.add(itemAssociation[i][j]);
	        }
	    }
	    
	    prepeareMapAssociationForGraph(itemAssociation,mapItemAssociation,columns,rows);
	    
	     for(String v : vertixes ){
	        dfs(v,mapItemAssociation);
	    }
	    
	    String[] result = longerPath.toArray(new String [0]);
	    return result;
	    
}
	private void dfs (String v, Map<String,List<String>> mapItemAssociation ){
	      Set<String> vizited =  new HashSet<>();
	      Stack<String> stack = new Stack<String>();
	      List<String> path =  new ArrayList<>();
	      
	      stack.add(v);
	      while(!stack.isEmpty()){
	          String item = stack.pop();
	          if(!vizited.contains(item)){
	              path.add(item);
	              
	              if(mapItemAssociation.get(item)!=null){
	                 List<String> neighbors = new ArrayList<>();
	                 neighbors =  mapItemAssociation.get(item);
	                 vizited.add(item);
	                 for(String neighbor :neighbors ){
	                     stack.push(neighbor);
	                 }
	              }
	          }
	      }
	      
	      if(longerPath.size() < path.size()){
	          longerPath.clear();
	          longerPath.addAll(path);
	      }
	      
	      vizited.clear();
	}
	
	
	private void prepeareMapAssociationForGraph(String[][] itemAssociation,Map<String,List<String>> mapItemAssociation,int columns,int rows){
	      for (int i = 0; i< rows; i++){
	        List<String> list = new ArrayList<>();
	        for(int j = 0; j< columns; j++){
	           list.add(itemAssociation[i][j]);
	        }
	        if(mapItemAssociation.get(itemAssociation[i][0]) != null){
	            List<String> temp = mapItemAssociation.get(itemAssociation[i][0]);
	            list.addAll(mapItemAssociation.put(itemAssociation[i][0],temp));
	        }
	        mapItemAssociation.put(itemAssociation[i][0],list);
    	}
	}
}