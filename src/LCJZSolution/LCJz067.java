package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz067 {

    class Solution {
        //-2147483648 , 2147483647
        public int strToInt(String str) {
            // 无法转换返回0
            if (str == null || str.length() == 0)
                return 0;
            char[] chars = str.toCharArray();

            int num = 0;
            boolean flag = true;
            boolean signseen = false;
            boolean numseen = false;
            for (int i = 0; i < str.length(); i++) {

                if (chars[i] == '+' || chars[i] == '-'  ){
                    if (signseen || numseen)
                        break;
                    signseen = true;
                    if (chars[i] == '-') {
                        flag = false;
                    }
                }
                else if (chars[i]>='0' && chars[i]<='9'){
                    if (num == 0 && chars[i] == '0')
                        return 0;
                    numseen = true;
                    // num * 10 + bitnum <= 2147483647
                    // num * 10 + bitnum >= -2147483648
                    int curnum = chars[i]-'0';
                    if (num == 0){
                        num += curnum;
                        if (!flag)
                            num = -num;
                    }
                    else {
                        if (num > 0) {
                            // 溢出
                            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && curnum > 7)) {
                                return Integer.MAX_VALUE;
                            }
                            num = num * 10 + curnum;
                        } else if (num < 0) {
                            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && curnum > 8)) {
                                return Integer.MAX_VALUE;
                            }
                            num = num * 10 - curnum;
                        }
                    }
                }
                else {
                    if (signseen || numseen)
                        break;
                    if (chars[i] == ' ')
                        continue;
                    return 0;
                }
            }
            return num;
        }
    }
}
