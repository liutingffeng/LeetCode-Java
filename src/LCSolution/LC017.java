package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC017 {

    class Solution {


        public List<String> letterCombinations(String digits) {

            Map<Character, String> digitsMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};

            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return res;
            }

            func(digitsMap, digits, new StringBuilder(""), res, 0);
            return res;
        }

        private void func(Map<Character, String> digitsMap, String digits, StringBuilder sb, List<String> res, int index) {
            if (index >= digits.length()) {
                res.add(sb.toString());
                return;
            }

            String temp = digitsMap.get(digits.charAt(index));
            for (int i = 0; i < temp.length(); i++) {
                sb.append(temp.charAt(i));
                func(digitsMap, digits, sb, res, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
}
