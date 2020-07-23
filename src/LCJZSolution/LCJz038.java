package LCJZSolution;

import java.util.*;

public class LCJz038 {

    class Solution {

        public String[] permutation(String s) {
            char[] array = s.toCharArray();
            List<String> res = new ArrayList<>();
            func(array, 0, res);
            return res.toArray(new String[0]);
        }

        private void func(char[] array,int start,List<String> res){
            if (start == array.length-1){
//                res.add(String.valueOf(array));
                res.add(new String(array));
                return;
            }
            //去重
            HashSet<Character> set = new HashSet<>();
            for (int i=start;i<array.length;i++){
                if (set.contains(array[i]))
                    continue;
                //交换  ，也就是在start位置固定字符
                set.add(array[i]);
                swap(array, start, i);
                func(array, start+1, res);
                swap(array, start, i);
            }
        }

        private void swap(char[] array,int i,int j){
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            return;
        }

    }
}
