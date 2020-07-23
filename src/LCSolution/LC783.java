package LCSolution;

public class LC783 {

    class Solution {
        //中序遍历！！！
        public int minDiffInBST(TreeNode root) {
            if (root.left == null && root.right==null)
                return Integer.MAX_VALUE;
            int ldiff = Integer.MAX_VALUE;
            if (root.left != null){
                TreeNode lnode = root.left;
                while (lnode.right!=null)
                    lnode = lnode.right;
                ldiff = Math.min(Math.abs(root.val-lnode.val),minDiffInBST(root.left));
            }
            int rdiff = Integer.MAX_VALUE;
            if (root.right!=null){
                TreeNode rnode = root.right;
                while (rnode.left!=null)
                    rnode = rnode.left;
                rdiff = Math.min( Math.abs(root.val-rnode.val),minDiffInBST(root.right));
            }
            return Math.min(ldiff, rdiff);
        }
    }
}
