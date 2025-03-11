package LC200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 */
public class LC244 {

//    private String[] wordsDict;
    private Map<String, List<Integer>> map;

    public LC244(String[] wordsDict) {
//        this.wordsDict = wordsDict;
        this.map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String e = wordsDict[i];
            List<Integer> list = map.getOrDefault(e, new ArrayList<>());
            list.add(i);
            map.put(e, list);
        }
    }

    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        if (map != null) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    res = Math.min(res, Math.abs(list1.get(i) - list2.get(j)));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
