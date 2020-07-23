package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC300 {

    class Solution {
        // dp[i] 代表以i 元素为结尾的最长的上升子序列
//        public int lengthOfLIS(int[] nums) {
//            if (nums == null || nums.length == 0)
//                return 0;
//            int n = nums.length;
//            int[] dp = new int[nums.length];
//            int res = 1;
//            Arrays.fill(dp, 1);
//            for (int i=1;i<n;i++){
//                for (int j=0;j<i;j++){
//                    if (nums[j]<nums[i])
//                        dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//                res = Math.max(res, dp[i]);
//            }
//            return res;
//        }

        /*

        相当于维护一个结果数组，如果当前元素比结果数组的值都大的的话，
        就追加在结果数组后面（相当于递增序列长度加了1）；
        否则的话用当前元素覆盖掉第一个比它大的元素（这样做的话后续递增序列才有可能更长，
        即使并没有更长，这个覆盖操作也并没有副作用哈，
        当然这个覆盖操作可能会让最终的结果数组值并不是最终的递增序列值，这无所谓）
         */

        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;

            int n = nums.length;
            int[] dp = new int[nums.length];

            int maxL = 0;
            for (int num : nums){
                //二分查找
                int lo = 0,ro = maxL;
                while (lo<ro){
                    int mid = (lo+ro)>>1;
                    if (dp[mid]>num)
                        ro = mid;
                    else
                        lo = mid+1;
                }

                dp[lo] = num;
                if (lo == maxL)
                    maxL++;
            }
            return maxL;
        }
    }
}
