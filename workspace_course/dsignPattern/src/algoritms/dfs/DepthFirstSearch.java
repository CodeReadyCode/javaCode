package algoritms.dfs;

import java.util.ArrayList;
import java.util.Stack;

import algoritms.bfs.Node;

public class DepthFirstSearch extends AbstractSearch {

	Node startNode;
	Node goalNode;

	public DepthFirstSearch(Node start, Node goalNode) {
		super(start, goalNode);
		this.startNode = start;
		this.goalNode = goalNode;
	}

	public boolean execute() {
		if (this.startNode.equals(goalNode)) {
			System.out.println("Goal Node Found at 0 depth");
			System.out.println(startNode);
		}
		Stack nodeStack = new Stack<Node>();
		ArrayList visitedNodes = new ArrayList<>();

		nodeStack.add(startNode);

		while (!nodeStack.isEmpty()) {
			Node current = (Node)nodeStack.pop();
			if (current.equals(goalNode)) {
				System.out.print(visitedNodes);
				System.out.println("Goal node found");
				return true;
			} else {
				visitedNodes.add(current);
				nodeStack.addAll(current.getChildren());
			}
		}
		return false;
	}

}
