package LC2022;

import java.util.*;

/**
 * [1,8,6,2,5,4,8,3,7]
 */
public class LC017 {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Arrays.asList(new String[]{});
        }

        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String val = map.get(c);
            if (i == 0) {
                for (int j = 0; j < val.length(); j++) {
                    res.add(String.valueOf(val.charAt(j)));
                }
                continue;
            }
            List<String> temp = new ArrayList<>();
            for (String s : res) {
                for (int j = 0; j < val.length(); j++) {
                    temp.add(s + val.charAt(j));
                }
            }
            res = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }

}
