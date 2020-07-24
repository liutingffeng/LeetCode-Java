package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC010 {

    class Solution {
//        public boolean isMatch(String s, String p) {
//            if (s == null || p == null)
//                return false;
//
//            int m = s.length();
//            int n = s.length();
//            char[] sc = s.toCharArray();
//            char[] pc = p.toCharArray();
//            return resc(sc, pc, m, n, 0, 0);
//        }
//
//        public boolean resc(char[] sc,char[] pc,int m,int n,int i,int j){
////            递归到底的情况
//            if (j >= n)
//                return i == m;
//
////            当前字符匹配的情况
//            boolean fmatch = sc[i] == pc[j] || (pc[j]=='.');
//            if (j+1<n && pc[j+1]== '*'){
//                return resc(sc, pc, m, n, i, j+2) || (fmatch && resc(sc, pc,m, n, i+1, j));
//            }
//            return fmatch && resc(sc, pc, m, n, i+1, j+1);
//        }

//          private int[][] memo;
////        动态规划
//          public boolean isMatch(String s, String p) {
//              if (s == null || p == null)
//                return false;
//
//            int m = s.length();
//            int n = p.length();
//            char[] sc = s.toCharArray();
//            char[] pc = p.toCharArray();
//            memo = new int[m+1][n+1];
//            return resc(sc, pc, m, n, 0, 0);
//        }
//
//        public boolean resc(char[] sc,char[] pc,int m,int n,int i,int j){
////            递归到底的情况
//            if (j >= n)
//                return i == m;
//
//            if (memo[i][j] != 0){
//                return memo[i][j]== 1? true:false;
//            }
////            当前字符匹配的情况
//            boolean res = false;
//            boolean fmatch = i<m && (sc[i] == pc[j] || (pc[j]=='.'));
//            if (j+1<n && pc[j+1]== '*'){
//                res =  resc(sc, pc, m, n, i, j+2) || (fmatch && resc(sc, pc,m, n, i+1, j));
//            }
//            else{
//                res = fmatch && resc(sc, pc, m, n, i+1, j+1);
//            }
//            memo[i][j] = res? 1:-1;
//            return res;
//        }


        public boolean isMatch(String s, String p) {
            if (s == null || p == null)
                return false;

            int m = s.length();
            int n = p.length();
            char[] sc = s.toCharArray();
            char[] pc = p.toCharArray();

            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;

            for (int i = 0; i <=m; i++) {
                for (int j = 1; j <=n ; j++) {
                    if (pc[j-1] == '*'){
                        dp[i][j] = (i>0 && (sc[i-1] == pc[j-2] || pc[j-2] == '.') && dp[i-1][j])
                                || dp[i][j-2];
                    }
                    else {
                        dp[i][j] = i>0 && (sc[i-1] == pc[j-1] || pc[j-1] == '.') && dp[i-1][j-1];
                    }
                }
            }

            return dp[m][n];
        }
    }
}
