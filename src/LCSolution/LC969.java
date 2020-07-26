package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC969 {

    class Solution {
        public List<Integer> pancakeSort(int[] A) {
            List<Integer> res = new ArrayList<>();

            for (int i = A.length-1; i > 0 ; i--) {
                int index = findMaxEle(A,i);
                if (index == i)
                    continue;

                //
                reverse(A,index);
                res.add(index+1);
                res.add(i+1);
                reverse(A,i);
            }

            return res;
        }

        private void reverse(int[] A, int i) {
            int l = 0, r = i;
            while (l<r){
                int temp = A[l];
                A[l++] = A[r];
                A[r--] = temp;
            }
        }

        private int findMaxEle(int[] A, int i) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (A[j]>A[maxIndex])
                    maxIndex = j;
            }
            return maxIndex;
        }
    }
}
