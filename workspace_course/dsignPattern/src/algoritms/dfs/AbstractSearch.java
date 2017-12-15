package algoritms.dfs;

import algoritms.bfs.Node;

/**
 * AbstractSearch class so that we have a template
 * that all future graph traversal algorithms must adhere to.
 * this will make it far easier to "hot-swap" different algorithms
 * out for testing later on.
 */
public abstract class AbstractSearch {

    Node startNode;
    Node goalNode;

    public AbstractSearch(Node startNode, Node goalNode){
        this.startNode = startNode;
        this.goalNode = goalNode;
    }

    public abstract boolean execute();

}