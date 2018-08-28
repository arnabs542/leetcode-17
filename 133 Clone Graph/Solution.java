/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> visitedNodeMap = new HashMap<>();
        return cloneGraph(node, visitedNodeMap);
    }

    // graph traverse, we can use BFS or DFS, use DFS here
    // use Map to avoid infinite call loop
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visitedNodeMap) {
        UndirectedGraphNode newNode = null;
        if (node != null) {
            // the node has been created, return the created one immediately
            if (visitedNodeMap.containsKey(node.label)) {
                return visitedNodeMap.get(node.label);
            }

            newNode = new UndirectedGraphNode(node.label);
            visitedNodeMap.put(node.label, newNode);
            for (UndirectedGraphNode neighbor: node.neighbors) {
                UndirectedGraphNode newNeighbor = cloneGraph(neighbor, visitedNodeMap);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return newNode;
    }
}