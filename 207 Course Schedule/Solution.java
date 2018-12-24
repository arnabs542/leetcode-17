class Solution {
    class Node {
        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        public int val;
        // the problem assumes no duplicate edges, no need to use set, list would be enough
        public List<Integer> children;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build dependency graph
        Map<Integer, Node> nodeMap = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            // build dependency relationship for each pair
            Node curNode = getNode(nodeMap, prerequisites[i][0]);
            if(findCirularGraph(nodeMap, prerequisites[i][1], prerequisites[i][0])) {
                return false;
            } else {
                curNode.children.add(prerequisites[i][1]);
            }
        }
        return true;
    }

    private Node getNode(Map<Integer, Node> nodeMap, int val) {
        if(nodeMap == null) return null;
        if(nodeMap.get(val) == null) {
            Node node = new Node(val);
            nodeMap.put(val, node);
            return node;
        } else {
            return nodeMap.get(val);
        }
    }

    private boolean findCirularGraph(Map<Integer, Node> nodeMap, int fromVal, int toVal) {
        if(fromVal == toVal) return true;

        Node fromNode = getNode(nodeMap, fromVal);
        List<Integer> fromNodeChildren = fromNode.children;
        for(int fromNodeChild: fromNodeChildren) {
            if(findCirularGraph(nodeMap, fromNodeChild, toVal)) {
                return true;
            }
        }
        return false;
    }
}