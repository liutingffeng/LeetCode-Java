package LCSolution;

import java.util.*;

public class LC336 {

    class Solution {
        // 暴力法,超时
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i+1; j < words.length; j++) {
                    if (isPalindrome(words[i]+words[j])){
                        res.add(Arrays.asList(i,j));
                    }
                    if (isPalindrome(words[j]+words[i])){
                        res.add(Arrays.asList(j,i));
                    }
                }
            }
            return res;
        }

        private boolean isPalindrome(String s){
            int l = 0, r = s.length()-1;
            while (l<r){
                if (s.charAt(l++)!=s.charAt(r--))
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new LC336().new Solution().palindromePairs(new String[]{"bat", "tab", "cat"});
        for (List l : lists){
            System.out.println(l.get(0)+","+l.get(1));
        }
    }

}
