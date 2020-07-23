package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC461 {

    class Solution {
        public int hammingDistance(int x, int y) {
            int z = x^y;
            int count = 0;
            while (z>0){
                if ((z&1) == 1)
                    count++;
                z = z>>1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int z = 1^4;
        System.out.println(z);
        int count = 0;
        while (z>0){
            if ((z&1) == 1)
                count++;
            z = z>>1;
        }
        System.out.println(count);
    }
}
