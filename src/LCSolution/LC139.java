package LCSolution;

import java.util.*;

public class LC139 {

    class Solution {
//        public boolean wordBreak(String s, List<String> wordDict) {
//            Set<String> set = new HashSet<>();
//            int minLength = Integer.MAX_VALUE;
//            for (String t:wordDict){
//                set.add(t);
//                if (t.length()<minLength)
//                    minLength = t.length();
//            }
//            return dfs(s, set, minLength);
//        }
//
//        private boolean dfs(String s, Set<String> wordDict,int minLength){
//            if (s.length()<minLength)
//                return false;
//            if (wordDict.contains(s))
//                return true;
//
//            for (int i = minLength-1;i<s.length();i++){
//                if (wordDict.contains(s.substring(0, i+1))){
//                    if (dfs(s.substring(i+1, s.length()),wordDict,minLength))
//                        return true;
//                }
//            }
//            return false;
//        }

//        public boolean wordBreak(String s, List<String> wordDict) {
//            int n = s.length();
//            //memo[i] s中 [0,i-1]可以拆分
//            boolean[] memo = new boolean[n+1];
//            memo[0] = true;
//            for (int i=1;i<=n;i++){
//                for (int j=0;j<i;j++){
//                    if (memo[j] && wordDict.contains(s.substring(j,i))){
//                        memo[i] = true;
//                        break;
//                    }
//                }
//            }
//            return memo[n];
//        }

        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;

            for (int i = 1; i < s.length()+1; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] == true){
                        if (wordDict.contains(s.substring(j, i))){
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
