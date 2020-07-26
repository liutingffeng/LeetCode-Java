package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC043 {

    class Solution {
        public String multiply(String num1, String num2) {
            char[] array1 = num1.toCharArray();
            char[] array2 = num2.toCharArray();
            int m = array1.length;
            int n = array2.length;

            int[] res = new int[m+n];

            for (int i = m-1; i >=0 ; i--) {
                for (int j = n-1; j >=0 ; j--) {
                    int mulp = (array1[i]-'0')*(array2[j]-'0');
                    mulp += res[i+j+1];
                    res[i+j+1] = mulp%10;
                    res[i+j] += mulp/10;
                }
            }
            int i =0 ;
            while (i<res.length && res[i] == 0)
                i++;

            //
            StringBuilder sb = new StringBuilder();
            for (;i<res.length;i++){
                sb.append(res[i]);
            }
            return sb.length() == 0? "0":sb.toString();
        }
    }
}
