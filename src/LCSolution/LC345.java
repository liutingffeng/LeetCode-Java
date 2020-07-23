package LCSolution;

import java.util.*;

public class LC345 {

    class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length()<=1)
                return s;
            HashSet<Character> hash = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
            int l = 0;
            int r = s.length()-1;
            char[] array = s.toCharArray();
            while (l<r){
                while (!hash.contains(array[l]) && l<r)
                    l++;
                while (!hash.contains(array[r]) && r>l)
                    r--;
                if (l<r){
                    char c = array[l];
                    array[l++] = array[r];
                    array[r--] = c;
                }
            }
            return String.valueOf(array);
        }
    }
}
