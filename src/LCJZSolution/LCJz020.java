package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz020 {

    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0)
                return false;

            char[] charArray = s.trim().toCharArray();

            //标记之前是否出现过
            boolean numseen = false;   //数字
            boolean dotseen = false;   // 点
            boolean eseen = false;    // 指数

            for (int i=0;i<charArray.length;i++){
                if (charArray[i]>='0' && charArray[i]<='9'){
                    numseen = true;
                }
                else if (charArray[i] == '.'){
                    //之前不能出现'.' 和'e'
                    if (dotseen || eseen)
                        return false;
                    dotseen = true;
                }
                else if (charArray[i] == 'e' || charArray[i] == 'E'){
                    //e之前必须有数字出现
                    if (!numseen || eseen)
                        return false;
                    eseen = true;
                    //将numseen 置为false 排除123e或者123e+的情况,确保e之后也出现数
                    numseen = false;
                }
                else if (charArray[i] == '+' || charArray[i] == '-'){
                    //不是首次出现，且前一个不是e
                    if (i!=0 && (charArray[i-1]!='e' && charArray[i-1]!='E'))
                        return false;
                }
                //其他不合法的字符
                else {
                    return false;
                }
            }
            return numseen;
        }
    }
}
