package LC2026;

import java.util.*;

/**
 * @Author liutingfeng
 * @Date 2026/4/4 00:34
 */
public class LCGraphDirection {
    Map<Integer, List<Integer>> adjList; // 邻接表：只存出边
    Set<Integer> vertices; // 顶点集合
    Map<Integer, Integer> outDegree; // 出度
    Map<Integer, Integer> inDegree; // 入度

    public LCGraphDirection(int[][] edges) {
        this.adjList = new HashMap<>();
        this.vertices = new HashSet<>();
        this.outDegree = new HashMap<>();
        this.inDegree = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            addEdge(src, dst);
        }
    }

    private void addVertex(int vertex) {
        if (vertices.contains(vertex)) {
            return;
        }
        vertices.add(vertex);
        adjList.put(vertex, new ArrayList<>());
        outDegree.put(vertex, 0);
        inDegree.put(vertex, 0);
    }

    private void addEdge(int src, int dst) {
        addVertex(src);
        addVertex(dst);
        adjList.get(src).add(dst);
        outDegree.put(src, outDegree.get(src) + 1);
        inDegree.put(dst, inDegree.get(dst) + 1);
    }

    private void removeEdge(int src, int dst) {
        if (!vertices.contains(src) || !vertices.contains(dst)) {
            return;
        }
        boolean removed = adjList.get(src).remove(Integer.valueOf(dst));
        if (removed) {
            outDegree.put(src, outDegree.get(src) - 1);
            inDegree.put(dst, inDegree.get(dst) - 1);
        }
    }

    private void removeVertex(int vertex) {
        if (!vertices.contains(vertex)) {
            return;
        }

        // 先删除 vertex 的所有出边
        List<Integer> outNeighbors = new ArrayList<>(adjList.get(vertex));
        for (int dst : outNeighbors) {
            removeEdge(vertex, dst);
        }

        // 再删除其他点指向 vertex 的所有入边
        for (int src : new ArrayList<>(vertices)) {
            if (src == vertex) {
                continue;
            }
            removeEdge(src, vertex);
        }

        vertices.remove(vertex);
        adjList.remove(vertex);
        outDegree.remove(vertex);
        inDegree.remove(vertex);
    }

    public void print() {
        for (int vertex : vertices) {
            System.out.println(vertex + ": " + adjList.get(vertex)
                    + " outDegree: " + outDegree.get(vertex)
                    + " inDegree: " + inDegree.get(vertex));
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
        LCGraphDirection graph = new LCGraphDirection(edges);
        graph.print();
    }
}
