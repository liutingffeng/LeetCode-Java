package LCSolution;

import java.util.*;

public class LC049 {

    class Solution {
//        public List<List<String>> groupAnagrams(String[] strs) {
//            List<List<String>> res = new ArrayList<>();
//            Map<String,List<String>> map = new HashMap<>();
//            for (int i=0;i<strs.length;i++){
//                char[] keyArray = strs[i].toCharArray();
//                Arrays.sort(keyArray);
//                String key = String.valueOf(keyArray);
//                System.out.println(key);
//                if (!map.containsKey(key)){
//                    map.put(key, new ArrayList<>());
//                }
//                map.get(key).add(strs[i]);
//            }
//            return new ArrayList<>(map.values());
//        }

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map = new HashMap<>();
            int[] count = new int[26];
            for (int i=0;i<strs.length;i++){
                Arrays.fill(count, 0);
                for (char c:strs[i].toCharArray()){
                    count[c-'a'] ++;
                }
                StringBuilder sb = new StringBuilder("");
                for (int j=0;j<26;j++){
                    sb.append(count[j]);
                }
                String key = sb.toString();
                if (!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(strs[i]);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        LC049.Solution solution = new LC049().new Solution();
        solution.groupAnagrams(strs);
    }
}
