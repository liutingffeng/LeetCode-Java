package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz056I {

    class Solution {
        //异或
        /*
        首先，计算机中 -i 是如何存储？
补码。
补码是如何计算呢?举个例子：假设数字 9 ，占位 8 位，即 0000 1001 , 8 = ( 0000 1000 ).
两种方法：

每位取反，再加 1 。 即 -9 = ( 1111 0111 )b
从右往左数，找到第一位为 1 的位， 1 左边全部取反， 1 右边不变。 即 -9 = ( 1111 0111 )b ， -8 = (
1111 1000 ).
用第二种方法计算：
9 & -9 = ( 0000 0001 )b
8 & -8 = ( 0000 1000 )b
————————————————
         */
        public int[] singleNumbers(int[] nums) {
            int sum = 0;
            for (int num:nums)
                sum ^=num;

            //得到sum的二进制的1的最低位
//            int flag=(-sum)&sum;
            int flag = 1;
            while ((sum&flag) ==0){
                flag <<= 1;
            }

            int a = 0;
            int b = 0;
            //分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
            for (int num : nums){
                if ((num&flag) == 0){
                    a ^= num;
                }
                else
                    b^=num;
            }
            return new int[]{a,b};
        }
    }
}
