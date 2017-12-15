package algoritms.bfs.dijkstra;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
 
public class Dijkstra {
                public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
                    source.setDistance(0);
               
                    Set<Node> settledNodes = new HashSet<>(); //visited
                    Set<Node> unsettledNodes = new HashSet<>(); //Q
               
                    unsettledNodes.add(source);
               
                    while (unsettledNodes.size() != 0) {
                        Node currentNode = getLowestDistanceNode(unsettledNodes);
                        unsettledNodes.remove(currentNode);
                        for (Entry < Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
                            Node adjacentNode = adjacencyPair.getKey();
                            Integer edgeWeight = adjacencyPair.getValue();
                            if (!settledNodes.contains(adjacentNode)) {
                                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                                unsettledNodes.add(adjacentNode);
                            }
                        }
                        settledNodes.add(currentNode);
                    }
                    return graph;
                }
 
                private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
                    Node lowestDistanceNode = null;
                    int lowestDistance = Integer.MAX_VALUE;
                    for (Node node: unsettledNodes) {
                        int nodeDistance = node.getDistance();
                        if (nodeDistance < lowestDistance) {
                            lowestDistance = nodeDistance;
                            lowestDistanceNode = node;
                        }
                    }
                    return lowestDistanceNode;
                }
 
                private static void calculateMinimumDistance(Node adjacentNode, Integer edgeWeigh, Node currentNode) {
                    Integer sourceDistance = currentNode.getDistance();
                    if (sourceDistance + edgeWeigh < adjacentNode.getDistance()) {
                        adjacentNode.setDistance(sourceDistance + edgeWeigh);
                        LinkedList<Node> shortestPath = new LinkedList<>(currentNode.getShortestPath());
                        shortestPath.add(currentNode);
                        adjacentNode.setShortestPath(shortestPath);
                    }
                }
}