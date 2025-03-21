package LC2023;

import java.util.HashMap;
import java.util.Map;

public class LC13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int res = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i+1 < s.length()) {
                char r = s.charAt(i+1);
                String cr = String.valueOf(c) + r;
                if (map.containsKey(cr)) {
                    res += map.get(cr);
                    i += 2;
                    continue;
                }
            }
            res += map.get(String.valueOf(c));
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        new LC13().romanToInt("MCMXCIV");
    }
}
