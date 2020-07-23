package LCJZSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCJz016 {

    class Solution {
        Double[] memo ;

        //有问题
//        public double myPow(double x, int n) {
//            if (n == 0)
//                return 1;
//            if (x == 0)
//                return 0;
//            boolean flag = n < 0 ? true : false;
//            n = Math.abs(n);
//            memo = new Double[n];
//            Arrays.fill(memo, -1.0);
//            memo[0] = x;
//            double res =  func(x, n);
//            if (flag)
//                res = 1.0/res;
//            return res;
//        }
//
//        private double func(double x,int n){
//            if (n == 1){
//                return memo[0];
//            }
//
//            int half = n/2;
//            if (memo[half]!=0){
//                memo[half] = func(x, half);
//            }
//            if (memo[n-half]!=0){
//                memo[n-half] = func(x, n-half);
//            }
//            return memo[half-1]*memo[n-half-1];
//        }

        //快速幂
        public double myPow(double x, int n) {
            if (x == 0)
                return 0;
            boolean flag = false;
            long b = n;
            if (n<0){
                b = -b;
                flag = true;
            }
            double res = 1.0;
            while (b>0){
                if ((b&1) == 1)
                    res *=x;
                x *=  x;
                b = b>>1;
            }
            return flag ? 1/res:res;
        }
    }
}
