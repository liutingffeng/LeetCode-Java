package LC2026;

import java.util.*;

public class LC373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // 小顶堆，存储 {sum, i, j}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n[0]));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int i = cur[1];
            int j = cur[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return result;
    }
    
}
