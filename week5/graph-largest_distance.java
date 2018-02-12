public class Solution {
    public class Node<T> {
        public T value;
        public List<Node<T>> neighbors;
        public Node(T value) {
            this.value = value;
            this.neighbors = new ArrayList();
        }
        
        public String toString() {
            return "[" + value.toString() + "]";
        }
    }
    
    public int solve(ArrayList<Integer> A) {
        ArrayList<Node<Integer>> nodes = new ArrayList();
        HashMap<Integer, ArrayList<Integer>> indiceMap = buildIndiceMap(A);
        //System.out.println(indiceMap);
        ArrayList<Integer> rootIndex = indexOfAll(-1, indiceMap);
        Node<Integer> root = new Node<Integer>(rootIndex.get(0));
        nodes.add(root);
        
        buildGraph(A, indiceMap, nodes, rootIndex.get(0), root);
        
        ArrayList<Node<Integer>> edges = findEdgeNodes(nodes);
        
        HashSet<Node<Integer>> visited = new HashSet();
        int maxDepth = 0;
        for (Node<Integer> edge : edges) {
            visited.clear();
            visited.add(edges.get(0));
            maxDepth = Math.max(maxDepth, maxDepth(visited, edge, 0));
        }
        //System.out.println(maxDepth);
        
        return maxDepth;
    }
    
    public int maxDepth(Set<Node<Integer>> visited, Node<Integer> node, int pathLength) {
        int maxLength = pathLength;
        
        for (Node<Integer> n : node.neighbors) {
            if (visited.contains(n)) continue;
            
            visited.add(n);
            maxLength = Math.max(maxLength, maxDepth(visited, n, pathLength + 1));
        }
        
        //System.out.println(visited.toString() + " " + maxLength);
        return maxLength;
    }
    
    public ArrayList<Node<Integer>> findEdgeNodes(ArrayList<Node<Integer>> nodes) {
        ArrayList<Node<Integer>> edges = new ArrayList();
        for (Node<Integer> node : nodes) {
            if (node.neighbors.size() == 1) {
                edges.add(node);
            }
        }
        
        return edges;
    }
    
    public void buildGraph(ArrayList<Integer> A, HashMap<Integer, ArrayList<Integer>> indiceMap, ArrayList<Node<Integer>> nodes, int value, Node<Integer> parent) {
        ArrayList<Integer> foundIndexes = indexOfAll(value, indiceMap);
        
        for (Integer index : foundIndexes) {
            Node<Integer> n = new Node(index);
            nodes.add(n);
            n.neighbors.add(parent);
            parent.neighbors.add(n);
            buildGraph(A, indiceMap, nodes, index, n);
        }
    }
    
    public HashMap<Integer, ArrayList<Integer>> buildIndiceMap(ArrayList<Integer> A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        for (int i = 0; i < A.size(); i++) {
            int value = A.get(i);
            ArrayList<Integer> list = map.getOrDefault(value, new ArrayList());
            list.add(i);
            map.put(value, list);
        }
        
        return map;
    }
    
    public ArrayList<Integer> indexOfAll(Integer obj, HashMap<Integer, ArrayList<Integer>> map){
        return map.getOrDefault(obj, new ArrayList());
    }
}
