package LC2026;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC114 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            // 先找到左子树的最右节点
            TreeNode leftRight = root.left;
            while (leftRight != null && leftRight.right != null) {
                leftRight = leftRight.right;
            }
            if (leftRight != null) {
                // 把当前节点的右子树挂到左子树的最右节点
                leftRight.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }


}
