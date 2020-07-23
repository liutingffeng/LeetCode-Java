package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC005 {

    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] record = new boolean[n][n];
            String res = "";
            for (int i=0;i<n;i++){
                for (int j=i;j>=0;j--){
                    if (s.charAt(i) == s.charAt(j) && (i-j<2 || record[i-1][j+1]))
                        record[i][j] = true;

                    if (record[i][j] && (i-j+1)>res.length())
                        res = s.substring(j,i+1);
                }
            }
            return res;
        }
    }
}
