package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC407 {

    class Solution {
        //带优先级的宽搜
        public int trapRainWater(int[][] heightMap) {
            int m = heightMap.length;
            int n = heightMap[0].length;
            if (m<3 || n<3)
                return 0;

            //优先队列
            Queue<int[]> pq = new PriorityQueue<>((o1,o2)->heightMap[o1[0]][o1[1]]-heightMap[o2[0]][o2[1]]);

            boolean[][] mark = new boolean[m][n];

            //初始化优先队列
            // * * * *
            // * o o *
            // * * * *
            // 将四周入队列
            for (int i = 0; i < m; i++) {
                pq.add(new int[]{i,0});
                mark[i][0] = true;
                pq.add(new int[]{i,n-1});
                mark[i][n-1] = true;
            }

            for (int i = 1; i < n-1; i++) {
                pq.add(new int[]{0,i});
                pq.add(new int[]{m-1,i});
                mark[0][i] = true;
                mark[m-1][i] = true;
            }

            // 方向数组
            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};

            int res = 0;
            //开始BFS
            while (!pq.isEmpty()){
                int[] cur = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int newx = cur[0]+dx[i];
                    int newy = cur[1]+dy[i];

                    if (newx<0 || newx>=m || newy<0 || newy>=n || mark[newx][newy])
                        continue;

                    // 有积水产生
                    int h = heightMap[cur[0]][cur[1]];
                    if (heightMap[newx][newy] < h){
                        res += h-heightMap[newx][newy];
                        heightMap[newx][newy] = h;
                    }

                    pq.add(new int[]{newx,newy});
                    mark[newx][newy] = true;
                }
            }

            return res;
        }
    }
}
