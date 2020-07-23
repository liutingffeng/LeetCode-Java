package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC344 {

    class Solution {
        public void reverseString(char[] s) {
            if (s == null || s.length<=1)
                return;

            int l = 0;
            int r = s.length-1;
            while (l<r){
                char c= s[l];
                s[l++] = s[r];
                s[r--] = c;
            }
        }
    }
}
