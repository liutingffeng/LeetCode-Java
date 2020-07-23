package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC008 {

    class Solution {
        public int myAtoi(String str) {

            int index = 0;
            int n = str.length();
            //空字符
            while (index<n && str.charAt(index)==' '){
                index++;
            }

            if (index == n){
                return 0;
            }

            boolean negative = false;
            if (str.charAt(index) == '-'){
                negative = true;
                index ++ ;
            }
            else if (str.charAt(index) == '+'){
                index++;
            }
            else if (!Character.isDigit(str.charAt(index))){
                return 0;
            }

            int ans = 0;
            while (index<n && Character.isDigit(str.charAt(index))){
                int number = str.charAt(index)-'0';
                if (ans > (Integer.MAX_VALUE-number)/10)
                    return negative? Integer.MIN_VALUE:Integer.MAX_VALUE;
                ans = ans*10+number;
                index++;
            }

            return negative? -ans:ans;
        }
    }
}
