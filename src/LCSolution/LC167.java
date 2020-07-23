package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC167 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int index1 = -1;
            int index2 = -2;
            int l = 0;
            int r = numbers.length-1;
            while (l<r){

                if (numbers[l]+numbers[r] == target){
                    index1 = l;
                    index2 = r;
                    break;
                }
                else if (numbers[l]+numbers[r] < target){
                    l++;
                }
                else
                    r--;

            }
            return new int[]{index1,index2};
        }
    }
}
