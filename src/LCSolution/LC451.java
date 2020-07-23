package LCSolution;

import java.util.*;

public class LC451 {

    class Solution {
        public String frequencySort(String s) {
            Map<Character,Integer> map = new HashMap<>();
            for (char c:s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            StringBuilder res = new StringBuilder();
            List<Map.Entry<Character,Integer>> list = new ArrayList<>();
            for (Map.Entry entry:map.entrySet()){
                list.add(entry);
            }
            list.sort((Map.Entry e1,Map.Entry e2)->(int)e2.getValue()-(int)e1.getValue());
            for (int i=0;i<list.size();i++){
                int count = list.get(i).getValue();
                char c = list.get(i).getKey();
                while (count-->0)
                    res.append(c);
            }
            return res.toString();
        }
    }
}
