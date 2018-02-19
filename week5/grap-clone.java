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
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeRef = new HashMap();
        LinkedList<UndirectedGraphNode> queue = new LinkedList();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            UndirectedGraphNode clone;
            if (!nodeRef.containsKey(n)) {
                clone = new UndirectedGraphNode(n.label);
                nodeRef.put(n, clone);
            } else {
                clone = nodeRef.get(n);
            }
            
            for (UndirectedGraphNode neighbor: n.neighbors) {
                UndirectedGraphNode newNeighbor;
                if (!nodeRef.containsKey(neighbor)) {
                    newNeighbor = new UndirectedGraphNode(neighbor.label);
                    nodeRef.put(neighbor, newNeighbor);
                    queue.add(neighbor);
                } else {
                    newNeighbor = nodeRef.get(neighbor);
                }
                clone.neighbors.add(newNeighbor);
            }
        }
        
        return nodeRef.get(node);
    }
}
