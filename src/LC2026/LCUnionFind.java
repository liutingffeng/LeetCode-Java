package LC2026;

public class LCUnionFind {
    // parent[i] 表示节点 i 的父节点；如果 parent[i] == i，说明 i 是集合根节点
    int[] parent;
    // size[i] 仅在 i 为根节点时有意义，表示该集合的元素个数
    int[] size;

    // 初始化：开始时每个元素各自独立，都是一个单独集合
    LCUnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 查找根节点，并在回溯时把路径上的点直接挂到根上（路径压缩）。
    //
    // 图例：假设当前 parent 关系是 0 -> 1 -> 2 -> 3，且 3 是根。
    // 调用 find(0) 前：
    //   0 -> 1 -> 2 -> 3(root)
    // 调用 find(0) 后（路径压缩）：
    //   0 ----\
    //   1 ----- > 3(root)
    //   2 ----/
    //
    // 这样后续再 find(0)/find(1)/find(2) 都几乎一步到根，查询更快。
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 合并两个集合：按集合大小合并，小树挂到大树上，避免树过高
    // 返回 true 表示发生了合并；返回 false 表示原本就在同一集合
    boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) {
            return false;
        }

        // 按大小合并，保证 ra 始终是较大集合的根
        if (size[ra] < size[rb]) {
            int t = ra;
            ra = rb;
            rb = t;
        }

        parent[rb] = ra;
        size[ra] += size[rb];
        return true;
    }

    // 判断两个元素是否连通：根节点相同则连通
    boolean connectd(int a, int b) {
        return find(a) == find(b);
    }

}
