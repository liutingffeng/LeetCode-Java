package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC547 {

    class Solution {
        class UF{
            //记录连同分量
            private int count;
            //节点x 的父节点 parent[x]
            private int[] parent;

            // 记录树的数值
            private int[] size;

            // 节点个数n
            public UF(int n) {
                this.count = n;
                parent = new int[n];
                size = new int[n];

                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            // 返回某个节点的根
            public int find(int x){
                while (parent[x]!=x){
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public void union(int p,int q){
                int proot = find(p);
                int qroot = find(q);
                if (proot == qroot){
                    return;
                }
                //合并
                if (size[proot]<size[qroot]) {
                    parent[proot] = qroot;
                    size[qroot] +=size[proot];
                }
                else {
                    parent[qroot] = proot;
                    size[proot] += size[qroot];
                }
                count--;
            }

            public boolean connected(int p,int q){
                return find(p) == find(q);
            }

            public int getCount() {
                return count;
            }
        }


        public int findCircleNum(int[][] M) {
            int n = M.length;
            UF uf = new UF(n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (M[i][j] == 1)
                        uf.union(i, j);
                }
            }
            return uf.getCount();
        }
    }
}
