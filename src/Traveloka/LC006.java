package Traveloka;

/**
 * @Author liutingfeng
 * @Date 2026/7/31 17:41
 */
public class LC006 {

    // 建立并查集
    static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 == root2) {
                return;
            }

            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    /**
     * 有 n 个节点，编号为 1 到 n。当两个节点 x 和 y 存在一个严格大于 threshold 的公因数时，两个节点之间建立无向边。
     * 给定多组查询 queries[i] = [a, b]，判断 a 和 b 是否直接或间接连通。
     * 输入：
     * n = 6
     * threshold = 2
     * queries = [[1,4], [2,5], [3,6]]
     *
     * 输出：
     * [false, false, true]
     * 3 和 6 拥有大于 2 的公因数 3，因此它们连通。
     * @param n
     * @param threshold
     * @param queries
     * @return
     */
    public static boolean[] areConnected(
            int n,
            int threshold,
            int[][] queries
    ) {
        UnionFind unionFind = new UnionFind(n + 1);

        /**
         * 两个节点 x 和 y 之间有边 ⟺ 存在公因数 f > threshold，即 x 和 y 都是 f 的倍数。
         * 反过来想：如果枚举出每一个可能的公因数 f（即 threshold+1 到 n），把 f 的所有倍数都连到 f 上，那么任意两个共享公因数 f 的节点，都会通过 f 这个"中转站"落在同一个连通分量里。
         * 查询时只需判断两个节点是否在同一个分量——这就是并查集擅长的事。
         */
        for (int factor = threshold + 1; factor <= n; factor++) {
            for (int multiple = factor * 2; multiple <= n; multiple += factor) {
                unionFind.union(factor, multiple);
            }
        }

        boolean[] answers = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int node1 = queries[i][0];
            int node2 = queries[i][1];

            answers[i] =
                    unionFind.find(node1) == unionFind.find(node2);
        }

        return answers;
    }

    public static void main(String[] args) {
        boolean[] result = areConnected(
                6,
                2,
                new int[][]{
                        {1, 4},
                        {2, 5},
                        {3, 6}
                }
        );

        System.out.println(java.util.Arrays.toString(result));
// [false, false, true]
    }
}
