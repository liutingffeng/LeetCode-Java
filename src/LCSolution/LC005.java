package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC005 {

    class Solution {
//        public String longestPalindrome(String s) {
//            int n = s.length();
//            boolean[][] record = new boolean[n][n];
//            String res = "";
//            for (int i=0;i<n;i++){
//                for (int j=i;j>=0;j--){
//                    if (s.charAt(i) == s.charAt(j) && (i-j<2 || record[i-1][j+1]))
//                        record[i][j] = true;
//
//                    if (record[i][j] && (i-j+1)>res.length())
//                        res = s.substring(j,i+1);
//                }
//            }
//            return res;
//        }

        // 通过双指针法，中心扩散法
        public String longestPalindrome(String s) {

            String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 找以i为中心的回文子串
                String s1 =  palindrome(s, i, i);
                // 找以i,i+1为中心的回文子串
                String s2 =  palindrome(s, i, i+1);

                res = res.length()<s1.length() ? s1:res;
                res = res.length()<s2.length() ? s2:res;
            }
            return res;
        }

        private String palindrome(String s, int i, int j) {

            while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            return s.substring(i+1, j);
        }
    }
}
