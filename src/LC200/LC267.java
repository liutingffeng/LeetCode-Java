package LC200;

import java.util.*;

/**
 * 
 *
 */
public class LC267 {

    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                continue;
            }
            set.add(c);
        }
        return set.size() <= 1;
    }

    public List<String> generatePalindromes(String s) {
        boolean can = canPermutePalindrome(s);
        if (!can)
            return Arrays.asList();

        // 小写字母构成
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] ++;
        }
        List<Character> characters = new ArrayList<>();
        char single = '1';
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0)
                continue;
            if (map[i] % 2 == 1)
                single = (char) ('a' + i);
            for (int j = 0; j < (map[i] / 2); j++) {
                characters.add((char) ('a' + i));
            }
        }

        Set<String> temp = new HashSet<>();
        dfs(temp, characters, new HashSet<>(), new StringBuilder(""));
        // zuhe
        List<String> res = new ArrayList<>();
        for (String cur : temp) {
            if (single != '1') {
                res.add(cur + single + help(cur));
            } else {
                res.add(cur + help(cur));
            }
        }
        return res;
    }

    private String help(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private void dfs (Set<String> res, List<Character> characters, Set<Integer> has, StringBuilder sb) {
        if (has.size() == characters.size()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < characters.size(); i++) {
            if (has.contains(i))
                continue;
            sb.append(characters.get(i));
            has.add(i);
            dfs(res, characters, has, sb);
            has.remove(i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        new LC267().generatePalindromes("aabb");
    }
}
