package LCSolution;

import java.util.*;

public class LC187 {

    class Solution {

        //
//        public List<String> findRepeatedDnaSequences(String s) {
//            int L = 10 , n = s.length();
//            Set<String> set = new HashSet<>();
//            Set<String> out = new HashSet<>();
//
//            for (int i = 0; i <= n-L; i++) {
//                String subStr = s.substring(i, i+L);
//                if (set.contains(subStr)){
//                    out.add(subStr);
//                }
//                else {
//                    set.add(subStr);
//                }
//            }
//            return new ArrayList<>(out);
//        }

        //位运算
        public List<String> findRepeatedDnaSequences(String s){
            List<String> res = new ArrayList<>();
            if (s.length()<10)
                return res;

            Map<Character,Integer> map = new HashMap<>();
            map.put('A', 0);
            map.put('C', 1);
            map.put('G', 2);
            map.put('T', 3);

            int[] bitmap = new int[1<<20];
            int val = 0 ;
            int mask = (1<<20) -1;  // 二进制20个1
            //类似与滑动窗口先把前10个字母组合
            for (int i = 0; i < 10; i++) {
                val = (val<<2) | (map.get(s.charAt(i)));
            }
            bitmap[val] = 1;
            for (int i = 10; i < s.length(); i++) {
                val = ((val<<2)&mask) | (map.get(s.charAt(i)));
                if (bitmap[val]>1){
                    continue;
                }
                if (bitmap[val]==1){
                    res.add(s.substring(i-9, i+1));
                    bitmap[val] = 2;
                }
                else {
                    bitmap[val] = 1;
                }
            }
            return res;
        }
    }
}
