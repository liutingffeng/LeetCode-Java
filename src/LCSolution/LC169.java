package LCSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC169 {

    class Solution {
//        public int majorityElement(int[] nums) {
//            Map<Integer,Integer> map = new HashMap<>();
//            int target = nums.length/2;
//            for (int num:nums){
//                map.put(num, map.getOrDefault(num, 0)+1);
//                if (map.get(num)>target)
//                    return num;
//            }
//
//            return 0;
//        }

//        public int majorityElement(int[] nums) {
//            //排序
//            Arrays.sort(nums);
//            return nums[nums.length/2];
//        }

        //摩尔投票
        /*
        候选人(cand_num)初始化为nums[0]，票数count初始化为1。
当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
当票数count为0时，更换候选人，并将票数count重置为1。
遍历完数组后，cand_num即为最终答案。

为何这行得通呢？
投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。

无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。

作者：gfu
链接：https://leetcode-cn.com/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
//        public int majorityElement(int[] nums) {
//            int candidate = nums[0];
//            int count = 1;
//            for (int i=1;i<nums.length;i++){
//                count = candidate == nums[i]? count+1:count-1;
//                if (count == 0){
//                    candidate = nums[i];
//                    count = 1;
//                }
//            }
//            return candidate;
//        }

        public int majorityElement(int[] nums) {
            return mergeSort(nums, 0, nums.length-1);
        }

        private int mergeSort(int[] nums, int l, int r){
            if (l>=r)
                return nums[l];

            int mid = l+(r-l)/2;
            int major1 = mergeSort(nums, l, mid);
            int major2 = mergeSort(nums, mid+1, r);
            if (major1 == major2)
                return major1;
            //
            int majorcount = (r-l+1)/2;
            int count1 = 0;
            int count2 = 0;
            for (int i = l; i <=r ; i++) {
                if (major1 == nums[i])
                    count1++;
                if (major2 == nums[i])
                    count2++;
            }

            return count1>count2 ? major1:major2;
        }
    }
}
