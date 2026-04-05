package LC2026;

import java.util.*;

public class LC133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 1 --- 2
     * 4 --- 3
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Node> vertices = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> cloneQueue = new ArrayDeque<>();
        Node newStart = new Node(node.val);
        vertices.put(newStart.val, newStart);

        queue.offer(node);
        cloneQueue.offer(newStart);
        visited.add(node.val);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node newCur = cloneQueue.poll();

            for (Node neighbor : cur.neighbors) {
                // 处理相邻的节点
                Node cloneNeighbor = vertices.get(neighbor.val);
                if (cloneNeighbor == null) {
                    cloneNeighbor = new Node(neighbor.val);
                }
                vertices.put(neighbor.val, cloneNeighbor);
                newCur.neighbors.add(cloneNeighbor);
                if (!visited.contains(neighbor.val)) {
                    queue.offer(neighbor);
                    cloneQueue.offer(cloneNeighbor);
                    visited.add(neighbor.val);
                }
            }
        }
        return newStart;
    }
}
