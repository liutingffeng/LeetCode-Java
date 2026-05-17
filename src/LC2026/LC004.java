package LC2026;

public class LC004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1 < nums2
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int all = m + n + 1;
        // l1 r1  l2 r2
        // l1 < r2  , l2 < r1
        int low = 0, high = m;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = all / 2 - i;
            int l1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int r1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int l2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int r2 = j == n ? Integer.MAX_VALUE : nums2[j];
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        new LC004().findMedianSortedArrays(nums1, nums2);
    }


}
