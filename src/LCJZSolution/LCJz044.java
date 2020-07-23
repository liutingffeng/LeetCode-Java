package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz044 {

    class Solution {
        public int findNthDigit(int n) {
            if (n<10)
                return n;
            //位数
            int digit = 1;
            while (n > digit*(9*Math.pow(10,digit-1))){
                n -= digit*(9*Math.pow(10,digit-1));
                digit++;
            }
            int num = (int) Math.pow(10, digit-1) + n/digit;
            int mod = n%digit;
            if (mod == 0)
                return (num-1)%10;
            return (int) ((num/(Math.pow(10, digit-mod)))%10);
        }
    }
}
