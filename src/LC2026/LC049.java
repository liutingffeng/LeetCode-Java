package LC2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> record = new HashMap<>();
        for (String cur : strs) {
            int[] count = new int[26];
            for (int j = 0; j < cur.length(); j++) {
                count[cur.charAt(j) - 'a']++;
            }
            int hashCode = Arrays.hashCode(count);
            if (record.containsKey(hashCode)) {
                record.get(hashCode).add(cur);
            } else {
                record.put(hashCode, new ArrayList<>());
                record.get(hashCode).add(cur);
            }
        }
        return new ArrayList<>(record.values());
    }
}
