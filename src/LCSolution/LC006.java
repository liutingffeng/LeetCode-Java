package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC006 {

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows<2)
                return s;
            List<StringBuilder> res = new ArrayList<>();

            for (int i=0;i<numRows;i++){
                res.add(new StringBuilder());
            }
            int index = 0;
            int flag = -1;
            for (int i=0;i<s.length();i++){
                if (index == 0 || index == numRows-1)
                    flag = -flag;
                res.get(index).append(s.charAt(i));
                index +=flag;
            }

            String resStr = "";
            for (StringBuilder sb:res){
                resStr += sb;
            }
            return resStr;
        }
    }
}
