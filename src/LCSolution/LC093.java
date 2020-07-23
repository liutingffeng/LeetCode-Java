package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC093 {

    class Solution {
        //"25525511135"
        //输出: ["255.255.11.135", "255.255.111.35"]
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            resc(s, res, 0, temp);
            return res;
        }

        private void resc(String s , List<String> res,int index,List<String> temp){
            if (temp.size() == 4){
                if (index == s.length()){
                    StringBuilder sb = new StringBuilder();
                    for (String str:temp){
                        sb.append(str).append(".");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    res.add(new String(sb));
                }
                return;
            }
            if (index >=s.length())
                return;

            int rindex = index;
            if (s.charAt(index)!='0')
                rindex = index+2;

            for (int i=index;i<=rindex && i<s.length();i++){
                String subStr = s.substring(index, i+1);
                if (Integer.valueOf(subStr).compareTo(255)>0)
                    return;
                temp.add(subStr);
                resc(s, res, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
