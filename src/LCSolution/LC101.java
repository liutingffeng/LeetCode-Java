package LCSolution;

public class LC101 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return func(root.left, root.right);
        }

        private boolean func(TreeNode left,TreeNode right){
            if (left == null && right == null)
                return true;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;

            return func(left.left, right.right) && func(left.right, right.left);
        }
    }
}
