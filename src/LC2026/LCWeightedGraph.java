package LC2026;

import java.util.*;

/**
 * @Author liutingfeng
 * @Date 2026/4/4
 */
public class LCWeightedGraph {
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    Map<Integer, List<Edge>> adjList;
    Set<Integer> vertices;
    boolean directed;

    public LCWeightedGraph(int[][] edges) {
        this(edges, false);
    }

    public LCWeightedGraph(int[][] edges, boolean directed) {
        this.adjList = new HashMap<>();
        this.vertices = new HashSet<>();
        this.directed = directed;
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
        }
    }

    private void addVertex(int vertex) {
        if (vertices.contains(vertex)) {
            return;
        }
        vertices.add(vertex);
        adjList.put(vertex, new ArrayList<>());
    }

    public void addEdge(int src, int dst, int weight) {
        addVertex(src);
        addVertex(dst);
        adjList.get(src).add(new Edge(dst, weight));
        if (!directed) {
            adjList.get(dst).add(new Edge(src, weight));
        }
    }

    public int shortestDistance(int start, int target) {
        if (!vertices.contains(start) || !vertices.contains(target)) {
            return -1;
        }
        if (start == target) {
            return 0;
        }

        Map<Integer, Integer> dist = dijkstra(start);
        int ans = dist.getOrDefault(target, Integer.MAX_VALUE);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public List<Integer> shortestPath(int start, int target) {
        List<Integer> path = new ArrayList<>();
        if (!vertices.contains(start) || !vertices.contains(target)) {
            return path;
        }
        if (start == target) {
            path.add(start);
            return path;
        }

        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        for (int vertex : vertices) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int curDist = cur[1];

            if (curDist > dist.get(node)) {
                continue;
            }
            if (node == target) {
                break;
            }

            for (Edge edge : adjList.get(node)) {
                int next = edge.to;
                int newDist = curDist + edge.weight;
                if (newDist < dist.get(next)) {
                    dist.put(next, newDist);
                    prev.put(next, node);
                    pq.offer(new int[]{next, newDist});
                }
            }
        }

        if (dist.get(target) == Integer.MAX_VALUE) {
            return path;
        }

        int cur = target;
        while (cur != start) {
            path.add(cur);
            cur = prev.get(cur);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }

    public Map<Integer, Integer> shortestDistanceFrom(int start) {
        if (!vertices.contains(start)) {
            return new HashMap<>();
        }
        return dijkstra(start);
    }

    // Bellman-Ford: 支持负权边；如果存在从 start 可达的负环，返回空表。
    public Map<Integer, Integer> bellmanFord(int start) {
        Map<Integer, Integer> dist = new HashMap<>();
        if (!vertices.contains(start)) {
            return dist;
        }

        for (int vertex : vertices) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        List<int[]> edges = getAllDirectedEdges();

        int n = vertices.size();
        for (int i = 1; i <= n - 1; i++) {
            boolean updated = false;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist.get(u) == Integer.MAX_VALUE) {
                    continue;
                }

                int newDist = dist.get(u) + w;
                if (newDist < dist.get(v)) {
                    dist.put(v, newDist);
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }

        // 再做一轮，若还能松弛，说明存在负环。
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist.get(u) == Integer.MAX_VALUE) {
                continue;
            }
            if (dist.get(u) + w < dist.get(v)) {
                return new HashMap<>();
            }
        }

        return dist;
    }

    // 检测从 start 可达区域是否存在负环。
    public boolean hasNegativeCycle(int start) {
        if (!vertices.contains(start)) {
            return false;
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int vertex : vertices) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        List<int[]> edges = getAllDirectedEdges();
        int n = vertices.size();

        for (int i = 1; i <= n - 1; i++) {
            boolean updated = false;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist.get(u) == Integer.MAX_VALUE) {
                    continue;
                }

                int newDist = dist.get(u) + w;
                if (newDist < dist.get(v)) {
                    dist.put(v, newDist);
                    updated = true;
                }
            }
            if (!updated) {
                return false;
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist.get(u) == Integer.MAX_VALUE) {
                continue;
            }
            if (dist.get(u) + w < dist.get(v)) {
                return true;
            }
        }
        return false;
    }

    // 统一按有向边列表返回，便于 Bellman-Ford 处理。
    private List<int[]> getAllDirectedEdges() {
        List<int[]> edges = new ArrayList<>();
        for (Map.Entry<Integer, List<Edge>> entry : adjList.entrySet()) {
            int u = entry.getKey();
            for (Edge edge : entry.getValue()) {
                edges.add(new int[]{u, edge.to, edge.weight});
            }
        }
        return edges;
    }

    // 仅用于无向连通图。若图不连通，返回 -1。
    public int primMstWeight() {
        if (directed || vertices.isEmpty()) {
            return -1;
        }

        int start = vertices.iterator().next();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        visited.add(start);
        for (Edge edge : adjList.get(start)) {
            pq.offer(new int[]{edge.to, edge.weight});
        }

        int mstWeight = 0;
        while (!pq.isEmpty() && visited.size() < vertices.size()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int weight = cur[1];
            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            mstWeight += weight;
            for (Edge edge : adjList.get(node)) {
                if (!visited.contains(edge.to)) {
                    pq.offer(new int[]{edge.to, edge.weight});
                }
            }
        }

        return visited.size() == vertices.size() ? mstWeight : -1;
    }

    public void print() {
        for (int vertex : vertices) {
            List<String> edgesInfo = new ArrayList<>();
            for (Edge edge : adjList.get(vertex)) {
                edgesInfo.add("(" + edge.to + "," + edge.weight + ")");
            }
            System.out.println(vertex + ": " + edgesInfo);
        }
    }

    private Map<Integer, Integer> dijkstra(int start) {
        Map<Integer, Integer> dist = new HashMap<>();
        for (int vertex : vertices) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int curDist = cur[1];

            if (curDist > dist.get(node)) {
                continue;
            }

            for (Edge edge : adjList.get(node)) {
                int next = edge.to;
                int newDist = curDist + edge.weight;
                if (newDist < dist.get(next)) {
                    dist.put(next, newDist);
                    pq.offer(new int[]{next, newDist});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 4}, {0, 2, 1}, {2, 1, 2}, {1, 3, 1}, {2, 3, 5}, {3, 4, 3}
        };

        LCWeightedGraph graph = new LCWeightedGraph(edges);
        graph.print();

        System.out.println("0 -> 4 最短距离: " + graph.shortestDistance(0, 4));
        System.out.println("0 -> 4 最短路径: " + graph.shortestPath(0, 4));
        System.out.println("从 0 出发的最短距离表: " + graph.shortestDistanceFrom(0));
        System.out.println("最小生成树权重: " + graph.primMstWeight());
    }
}

