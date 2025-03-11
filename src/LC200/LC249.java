package LC200;

import java.util.*;
import java.util.stream.Stream;

/**
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
 *
 *
 *
 * 示例：
 *
 * 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
 * 输出：
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 * 解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。
 *
 */
public class LC249 {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = caculate(s);
            List<String> datas = map.get(key);
            if (datas == null) {
                datas = new ArrayList<>();
                map.put(key, datas);
            }
            datas.add(s);
        }
        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            res.add(v);
        });
        return res;
    }

    private String caculate(String s) {
        if (s.length() == 1)
            return "-1";
        StringBuilder sb = new StringBuilder("");
        sb.append(s.length() + "-");
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i-1)) {
                sb.append(Math.abs(s.charAt(i) - s.charAt(i-1) + 26));
            } else {
                sb.append(Math.abs(s.charAt(i) - s.charAt(i-1)) % 26);
            }
        }
        return sb.toString();
    }

    private String[] find(String s) {
        int length = s.length();
        char[] left = new char[length];
        char[] right= new char[length];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                left[i] = 'z';
                right[i] = 'b';
            } else if (c == 'z') {
                left[i] = 'y';
                right[i] = 'a';
            } else {
                left[i] = (char) (c - 'a' - 1 + 'a');
                right[i] = (char) (c - 'a' + 1 + 'a');;
            }
        }
        return new String[]{new String(left), new String(right)};
    }


    public static void main(String[] args) {
        String[] strings = new LC249().find("abc");
        Stream.of(strings).forEach(System.out::println);

        String s1 = new LC249().caculate("az");
        String s2 = new LC249().caculate("ba");
        System.out.println(s1);
        System.out.println(s2);
        String s3 = new LC249().caculate("ab");
        String s4 = new LC249().caculate("ba");
        System.out.println(s3);
        System.out.println(s4);


    }
}
