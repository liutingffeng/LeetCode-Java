package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC125 {

    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length()<=1)
                return true;

            int l = 0;
            int r = s.length()-1;
            char[] array = s.toLowerCase().toCharArray();
            while (l<r){
               if (!isNumOrChar(array[l]))
                   l++;
               if (!isNumOrChar(array[r]))
                   r--;
               if (isNumOrChar(array[l]) && isNumOrChar(array[r])) {
                   if (array[l] != array[r])
                       return false;
                   l++;
                   r--;
               }
            }
            return true;
        }

        boolean isNumOrChar(char c){
            if(Character.isLetterOrDigit(c))
                return true;
            return false;
        }


    }
}
