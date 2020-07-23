package LCSolution;

public class LC222 {

    class Solution {
        /**
         完全二叉树的高度可以直接通过不断地访问左子树就可以获取
         判断左右子树的高度:
         如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
         如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
         **/
        public int countNodes(TreeNode root) {
            if (root == null)
                return 0;
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
}
