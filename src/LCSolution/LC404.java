package LCSolution;

public class LC404 {

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null)
                return 0;
            if (root.left == null){
                return sumOfLeftLeaves(root.right);
            }
            TreeNode lnode = root.left;
            if (lnode.left == null && lnode.right==null)
                return lnode.val+sumOfLeftLeaves(root.right);
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        }
    }
}
