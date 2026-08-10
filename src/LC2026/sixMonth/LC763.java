package LC2026.sixMonth;

import java.util.*;

public class LC763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            record.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, record.get(s.charAt(i)));
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LC763().partitionLabels("ababcbacadefegdehijhklij");
    }
}
