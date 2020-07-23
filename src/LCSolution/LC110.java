package LCSolution;

public class LC110 {

    class Solution {
        //在判断是否平衡的过程中把树的高度也判断了
        public boolean isBalanced(TreeNode root) {
            return treeHeight(root)>=0;
        }

        // -1表示不平衡了
        private int treeHeight(TreeNode root){
            if (root == null)
                return 0;
            int lh = treeHeight(root.left);
            int rh = treeHeight(root.right);
            if (lh>=0 && rh>=0 && Math.abs(lh-rh)<=1){
                return Math.max(lh, rh)+1;
            }
            else
                return -1;
        }
    }
}
