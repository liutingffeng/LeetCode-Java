package LCSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC290 {

    class Solution {
//        public boolean wordPattern(String pattern, String str) {
//            Map<Character,String> map = new HashMap<>();
//            String[] strArray = str.split(" ");
//            if (pattern.length()!=strArray.length)
//                return false;
//            for (int i=0;i<pattern.length();i++){
//                char c = pattern.charAt(i);
//                if (map.containsKey(c)){
//                    if (!map.get(c).equals(strArray[i]))
//                        return false;
//                } else {
//                    if (map.containsValue(strArray[i]))
//                        return false;
//                    map.put(c, strArray[i]);
//                }
//            }
//            return true;
//        }

        public boolean wordPattern(String pattern, String str){
            Map<Character,String> map = new HashMap<>();
            String[] strArray = str.split(" ");
            if (pattern.length()!=strArray.length)
                return false;
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (map.containsKey(c)){
                    if (!map.get(c).equals(strArray[i]))
                        return false;
                }
                else {
                    if (map.containsValue(strArray[i])){
                        return false;
                    }
                    map.put(c, strArray[i]);
                }
            }
            return true;
        }
    }
}
