package LCJZSolution;

public class LCJz019 {

    class Solution {
//        public boolean isMatch(String s, String p) {
//            return func(s.toCharArray(), p.toCharArray(), 0, 0);
//        }
//
//        private boolean func(char[] chars,char[] charp,int i,int j){
//            if (i>=chars.length && j>=charp.length)
//                return true;
//            if (j>=charp.length)
//                return false;
//
//            if (j>=charp.length)
//                return i == chars.length;
//            //当前字符是否匹配
//            boolean f_match = i<chars.length && (chars[i] == charp[j] || (charp[j] == '.'));
//
//            // * 匹配零次或多次
//            //下一个字符为"*"
//            if (j<charp.length-1 && charp[j+1] == '*'){
//                return func(chars, charp, i, j+2) || (f_match && func(chars, charp, i+1, j));
//            }
//            return f_match && func(chars, charp, i+1, j+1);
//        }

        //动态规划
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length()+1][p.length()+1];
            //初始化dp[0][0]=true,dp[0][1]和dp[1][0]~dp[s.length][0]默认值为false所以不需要显式初始化
            dp[0][0] = true;
            //填写第一行dp[0][2]~dp[0][p.length]
            for (int i=2;i<=p.length();i++){
                dp[0][i] = p.charAt(i-1)=='*' && dp[0][i-2];
            }

            //填写dp数组剩余部分
            for (int i=1;i<=s.length();i++){
                for (int j=1;j<=p.length();j++){
                    //p第j-1个字符是否为*
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j-2] || (dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'));
                    }
                    else {
                        //s的i元素和p的j元素是否相等,相等则移除s的i元素[i-1]和p的j元素[j-1]
                        dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.');
                    }
                }
            }

            return dp[s.length()][p.length()];
        }
    }
}
