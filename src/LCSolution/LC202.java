package LCSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC202 {

    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            set.add(n);
            while (n!=1){
                n = addSquare(n);
                if (set.contains(n))
                    return false;
                set.add(n);
            }
            return true;
        }

        public int addSquare(int n){
            int sum = 0;
            while (n > 0){
                sum += Math.pow(n%10,2);
                n /=10;
            }
            return sum;
        }

        /*
        //参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
//如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
//两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。
         */
    }
}
