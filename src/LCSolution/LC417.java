package LCSolution;

import java.util.*;

public class LC417 {

    static class Solution {
        //这种解法时间复杂度太低了

//        boolean lt = false;
//        boolean rb = false;
//        int m ;
//        int n ;
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//        int[][] dp;
//        boolean[][] visited;
//        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//            List<List<Integer>> res = new ArrayList<>();
//            if (matrix == null || matrix.length == 0)
//                return res;
//            m = matrix.length;
//            n = matrix[0].length;
//            dp = new int[m][n];
//            visited = new boolean[m][n];
//            for (int i=0;i<m;i++){
//                for (int j=0;j<n;j++){
//                    lt = false;
//                    rb = false;
//                    if (dfs(matrix, i, j)){
//                        res.add(new ArrayList<>(Arrays.asList(i,j)));
//                    }
//                }
//            }
//            return res;
//        }
//
//        private boolean dfs(int[][] matrix,int x,int y){
////            if (dp[x][y] == 1)
////                return true;
////            else if (dp[x][y] == -1)
////                return false;
//            if (x == 0 || y== 0)
//                lt = true;
//            if (x == m-1 || y==n-1)
//                rb = true;
//            if (lt&&rb) {
////                dp[x][y] = 1;
//                return true;
//            }
//
//            for (int k=0;k<4;k++){
//                int nextx = x+dx[k];
//                int nexty = y+dy[k];
//                if ((nextx>=0 && nextx<m) && (nexty>=0 && nexty<n)){
//                    if (matrix[nextx][nexty]<=matrix[x][y] && !visited[nextx][nexty]) {
//                        visited[x][y] = true;
//                        boolean res = dfs(matrix, nextx, nexty);
//                        visited[x][y] = false;
//                        if (res)
//                            return true;
//                    }
//                }
//            }
////            dp[x][y] = -1;
//            return false;
//        }

        /**
         建立两个矩阵Atlantic和Pacific, 当Atlantic[i][j]和Pacific[i][j]同时为true时表示该位置可以同时到达Atlantic和Pacific
         便历时的技巧为: 只需要从四个边界开始遍历即可(类似泛洪的思想, 只要可以从边界出发到达, 就说明该位置的水可以流向对应的海洋)
         **/
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0)
                return res;
            int m = matrix.length;
            int n = matrix[0].length;
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        new Solution().pacificAtlantic(matrix);
    }
}
