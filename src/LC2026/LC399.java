package LC2026;

import java.util.*;

public class LC399 {

    class Edge {
        String to;
        double weight;

        public Edge(String to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    // 图的关系
    Map<String, List<Edge>> adjList;
    // 顶点
    Set<String> vertices;


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adjList = new HashMap<>();
        vertices = new HashSet<>();
        // 构建图
        buildGraph(equations, values);

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> querie = queries.get(i);
            res[i] = findResult(querie.get(0), querie.get(1));
        }
        return res;
    }

    private double findResult(String src, String dest) {
        if (!vertices.contains(src) || !vertices.contains(dest)) {
            return -1.0;
        }
        // 2个顶点都存在
        // 顶点相等
        if (src.equals(dest)) {
            return 1.0;
        }
        // 不相等
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        // key 代表从 stat / key 的结果
        Map<String, Double> dist = new HashMap<>();

        queue.offer(src);
        visited.add(src);
        dist.put(src, 1.0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            // 查找相邻节点
            for (Edge edge : adjList.get(cur)) {
                String next = edge.to;
                if (visited.contains(next)) {
                    continue;
                }
                if (dest.equals(next)) {
                    // 找到目标了
                    return dist.get(cur) * edge.weight;
                }
                // 加入队列里
                queue.offer(next);
                visited.add(next);
                dist.put(next, dist.get(cur) * edge.weight);
            }
        }
        return -1.0;
    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            addEdge(equation.get(0), equation.get(1), values[i]);
        }
    }

    private void addVertex(String vertice) {
        if (vertices.contains(vertice)) {
            return;
        }
        vertices.add(vertice);
        adjList.put(vertice, new ArrayList<>());
    }

    private void addEdge(String from, String to, double value) {
        addVertex(from);
        addVertex(to);
        adjList.get(from).add(new Edge(to, value));
        // 无向图
        adjList.get(to).add(new Edge(from, 1.0 / value));
    }

}
