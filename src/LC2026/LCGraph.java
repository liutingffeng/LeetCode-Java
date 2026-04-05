package LC2026;

import java.util.*;

/**
 * @Author liutingfeng
 * @Date 2026/4/3 23:56
 */
public class LCGraph {
    // 邻接表：每个顶点维护一个邻接列表
    Map<Integer, List<Integer>> adjList; // key: 顶点，value: 邻接列表
    Set<Integer> vertices; // 顶点集合
    Map<Integer, Integer> degree; // 顶点度数

    public LCGraph(int[][] edges) {
        this.adjList = new HashMap<>();
        this.vertices = new HashSet<>();
        this.degree = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            addEdge(src, dst);
        }
    }

    /**
     * 添加顶点
     * @param vertex
     */
    private void addVertex(int vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            adjList.put(vertex, new ArrayList<>());
            degree.put(vertex, 0);
        }
    }
    
    /**
     * 删除顶点
     * @param vertex
     */
    private void removeVertex(int vertex) {
        if (!vertices.contains(vertex)) {
            return;
        }

        List<Integer> neighbors = new ArrayList<>(adjList.get(vertex));
        for (int neighbor : neighbors) {
            removeEdge(vertex, neighbor);
        }

        vertices.remove(vertex);
        adjList.remove(vertex);
        degree.remove(vertex);
    }

    /**
     * 添加边
     * @param src
     * @param dst
     */
    private void addEdge(int src, int dst) {
        addVertex(src);
        addVertex(dst);
        adjList.get(src).add(dst);
        adjList.get(dst).add(src);
        degree.put(src, degree.get(src) + 1);
        degree.put(dst, degree.get(dst) + 1);
    }

    /**
     * 删除边
     * @param src
     * @param dst
     */
    private void removeEdge(int src, int dst) {
        if (!vertices.contains(src) || !vertices.contains(dst)) {
            return;
        }

        boolean removedFromSrc = adjList.get(src).remove(Integer.valueOf(dst));
        boolean removedFromDst = adjList.get(dst).remove(Integer.valueOf(src));

        if (removedFromSrc) {
            degree.put(src, degree.get(src) - 1);
        }
        if (removedFromDst) {
            degree.put(dst, degree.get(dst) - 1);
        }
    }


    public void print() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public int getDegree(int vertex) {
        return degree.getOrDefault(vertex, 0);
    }

    public List<Integer> getNeighbors(int vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }

    public List<Integer> bfsOrder(int start) {
        List<Integer> order = new ArrayList<>();
        if (!vertices.contains(start)) {
            return order;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order.add(cur);

            for (int neighbor : getNeighbors(cur)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return order;
    }

    public int shortestDistance(int start, int target) {
        if (!vertices.contains(start) || !vertices.contains(target)) {
            return -1;
        }
        if (start == target) {
            return 0;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> dist = new HashMap<>();

        queue.offer(start);
        dist.put(start, 0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curDist = dist.get(cur);

            for (int neighbor : getNeighbors(cur)) {
                if (dist.containsKey(neighbor)) {
                    continue;
                }

                dist.put(neighbor, curDist + 1);
                if (neighbor == target) {
                    return curDist + 1;
                }
                queue.offer(neighbor);
            }
        }

        return -1;
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

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> prev = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int cur = queue.poll();
            for (int neighbor : getNeighbors(cur)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                visited.add(neighbor);
                prev.put(neighbor, cur);

                if (neighbor == target) {
                    found = true;
                    break;
                }
                queue.offer(neighbor);
            }
        }

        if (!found) {
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

    public static void main(String[] args) {
        // 图结构:
        //
        // 测试用例: edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 3}, {2, 4}}
        //
        //         1
        //        /|\
        //       0 | 2
        //        \|/ \
        //         3---4
        //
        // 邻接表:     度数:
        //   0: [1, 2]    0 → 2
        //   1: [0, 2, 3] 1 → 3
        //   2: [0, 1, 3, 4] 2 → 4
        //   3: [1, 2]    3 → 2
        //   4: [2]       4 → 1
        //
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
        LCGraph graph = new LCGraph(edges);
        graph.print();

        System.out.println("\n度数查询:");
        for (int i = 0; i <= 4; i++) {
            System.out.println("顶点 " + i + " 的度数: " + graph.getDegree(i));
        }
    }
}
