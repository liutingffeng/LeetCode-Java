package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC131 {

    class Solution {
        //分割回文串
        //输入: "aab"
        //输出:
        //[
        //  ["aa","b"],
        //  ["a","a","b"]
        //]
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            resc(s, 0, res, temp);
            return res;
        }

        private void resc(String s,int index,List<List<String>> res,List<String> temp){
            if (index == s.length()){
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i=index;i<s.length();i++){
                String subStr = s.substring(index, i+1);
                if (issys(subStr)){
                    temp.add(subStr);
                    resc(s, i+1, res, temp);
                    temp.remove(temp.size()-1);
                }
            }
        }

        private boolean issys(String s){
            if (s.length()<=1)
                return true;
            int l = 0 ,r=s.length()-1;
            while (l<r){
                if (s.charAt(l)!=s.charAt(r))
                    return false;
                l++;
                r--;
            }
            return true;
        }
    }
}
