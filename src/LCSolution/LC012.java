package LCSolution;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC012 {

    class Solution {
        public String intToRoman(int num) {
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder res = new StringBuilder();
            for (int i=0;i<13;i++){
                while (num>=nums[i]){
                    num = num-nums[i];
                    res.append(romans[i]);
                }
            }
            return res.toString();
        }
    }
}
