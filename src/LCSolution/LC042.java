package LCSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC042 {

    class Solution {
//        //一行一行读取
//        //时间复杂度O(n*m)
//        public int trap(int[] height) {
//            if (height == null || height.length == 0){
//                return 0;
//            }
//            int maxheight = getMaxHeight(height);
//            int res = 0;
//            for (int j=1;j<=maxheight;j++){
//                boolean started = false;
//                int temp = 0;
//                for (int i=0;i<height.length;i++){
//                    if (started && height[i]<j){
//                        temp ++;
//                    }
//                    if (height[i]>=j){
//                        started = true;
//                        res = res + temp;
//                        temp = 0;
//                    }
//                }
//            }
//            return res;
//        }
//
//        private int getMaxHeight(int[] height){
//            int maxH = 0;
//            for (int i:height){
//                if (i > maxH){
//                    maxH = i;
//                }
//            }
//            return maxH;
//        }

        //按列求取，每次循环求当前列的左右最低墙是否大于当前列的高度
        //O(n2)
//        public int trap(int[] height) {
//            if (height == null || height.length == 0){
//                return 0;
//            }
//            int res = 0;
//            //边界处直接跳过
//            for (int i=1;i<height.length-1;i++){
//                int curH = height[i];
//                int l = i,r=i;
//                int mxL = 0;
//                int mxR = 0;
//                while (--l>=0){
//                    if (height[l]>mxL)
//                        mxL = height[l];
//                }
//                while (++r<height.length){
//                    if (height[r]>mxR)
//                        mxR = height[r];
//                }
//                int minH = Math.min(mxL, mxR);
//                if (minH>curH){
//                    res += minH-curH;
//                }
//            }
//            return res;
//        }

        //动态规划，存储当前列左右两边的柱子的最高值
        //空间复杂度O(n)
//        public int trap(int[] height) {
//            if (height == null || height.length == 0){
//                return 0;
//            }
//            int length = height.length;
//            int[] memoL = new int[length];
//            for (int i=1;i<length;i++){
//                memoL[i] = Math.max(memoL[i-1],height[i-1]);
//            }
//            int[] memoR = new int[length];
//            for (int i=length-2;i>=0;i--){
//                memoR[i] = Math.max(memoR[i+1],height[i+1]);
//            }
//            int res = 0;
//            for (int i=1;i<length-1;i++){
//                int minH = Math.min(memoL[i],memoR[i]);
//                if (minH>height[i])
//                    res +=minH-height[i];
//            }
//            return res;
//        }


        /*
        使用两个指针，一个 left_max ，一个 right_max

        这个双指针是怎么个使用法呢？
        首先每次循环开始，先获取 left 的左边 [0, left - 1] 最高柱子高度 和 right 右边 [right + 1, len - 1] 最高柱子高度（都不包括 left 和 right 本身）
        当 left_max < right_max 时，那么就说明对于 left 右边一定有比 left_max 更高的柱子，那么只需要判断 left 左边 最高柱子 left_max 是否比 left 柱子高就行了，如果是，那么就能装水
        当 left_max >= right_max 时，那么就说明对于 right 左边一定有比 right_max 更高或者相同高度的柱子，那么只需要判断 right 右边最高柱子 right_max 是否比 right 柱子高就行了
        其实就是保证哪边稳定有高柱子就查看哪边

        为什么可以隔这么远进行判断？
        比如 对于 left 柱子，如果 left_max 比 left 高，那么如果 right_max 比 left_max 高，那么就跟上面说的 left 右边一定存在比 left 高的柱子，那么 left 柱能装水，
        就算 right_max 对于 left 右边来说不是最高的柱子也无所谓，因为如果不是最高的柱子，那么同样存在另一个比 left 高的柱子，那么 left 同样也能装水，且装水量同样是 left_max - left

        当 left_max < right_max 时，那么当前柱 left 装水量就是直接 left_max - height[left];
        当 left_max >= right_max 时，那么当前柱 right 装水量就是直接， right_max - height[right]
        */
        //将空间复杂度降为O(1)
//        public int trap(int[] height) {
//            int max_left = 0;
//            int max_right = 0;
//            int left = 1;
//            int right = height.length-2;
//            int res = 0;
//            while (left<=right){
//                max_left = Math.max(max_left, height[left-1]);
//                max_right = Math.max(max_right, height[right+1]);
//                if (max_left < max_right){
//                    if (max_left>height[left]){
//                        res +=max_left-height[left];
//                    }
//                    left++;
//                }
//                else {
//                    if (max_right>height[right]){
//                        res += max_right-height[right];
//                    }
//                    right --;
//                }
//            }
//            return res;
//        }


        //栈,单调递减栈
        public int trap(int[] height) {
            int res = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i=0;i<height.length;i++){
                while (!stack.isEmpty() && height[i]>height[stack.peek()]){
                    int curH = height[stack.pop()];
                    if (!stack.isEmpty()) {
                        int indexL = stack.peek();
                        int minH = Math.min(height[indexL], height[i]);
                        res += (minH - curH) * (i - indexL - 1);
                    }
                }
                stack.push(i);
            }
            return res;
        }
    }
}
