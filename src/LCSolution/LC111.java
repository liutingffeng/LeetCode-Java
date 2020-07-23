package LCSolution;

public class LC111 {

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            if (root.left == null && root.right == null)
                return 1;
            int curDepth = 0;
            if (root.left == null || root.right == null){
                curDepth = 1 + (root.left == null ? minDepth(root.right):minDepth(root.left));
            }
            else {
                curDepth = 1 + Math.min(minDepth(root.left), minDepth(root.right));
            }
            return curDepth;
        }
    }
}
