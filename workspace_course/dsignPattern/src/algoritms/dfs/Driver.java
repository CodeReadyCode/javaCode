package algoritms.dfs;

import algoritms.bfs.Node;

public class Driver {

	public static void main(String args[]) {
		Node station1 = new Node("Westminster", null, null);
		Node station2 = new Node("Waterloo", station1, null);
		Node station3 = new Node("Trafalgar Square", station1, station2);
		Node station4 = new Node("Canary Wharf", station2, station3);
		Node station5 = new Node("London Bridge", station4, station3);
		Node station6 = new Node("Tottenham Court Road", station5, station4);

		// We instantiate searchAlgo as type AbstractSearch but we set it to
		// equal
		// our newly created DepthFirstSearch concrete class implementation
		AbstractSearch searchAlgo = new DepthFirstSearch(station6, station1);

		if (searchAlgo.execute())
			System.out.print("Path Found!");
	}
}