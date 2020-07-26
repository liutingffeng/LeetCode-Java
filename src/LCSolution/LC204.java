package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC204 {

    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrim = new boolean[n];
            Arrays.fill(isPrim, true);
            int count = 0;
            for (int i = 2; i*i < n; i++) {
                if (isPrim[i]){
                    for (int j = i*i; j < n; j+=i) {
                        isPrim[j] = false;
                    }
                }
            }

            for (int i = 2; i < n; i++) {
                if (isPrim[i])
                    count++;
            }
            return count;
        }
    }
}
