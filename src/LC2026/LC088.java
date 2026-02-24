package LC2026;

public class LC088 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null)
            return;
        int k = m + n - 1;
        // 双指针
        while ((n - 1) >= 0) {
            if ((m - 1) < 0) {
                nums1[k] = nums2[n - 1];
                k--;
                n--;
                continue;
            }
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[k] = nums1[m - 1];
                m--;
                k--;
            } else {
                nums1[k] = nums2[n - 1];
                n--;
                k--;
            }
        }
    }


}
