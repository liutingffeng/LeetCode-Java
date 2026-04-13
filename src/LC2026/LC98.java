package LC2026;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC98 {


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

    private TreeNode last = null;

    public boolean isValidBST(TreeNode root) {
        // 中序遍历判断是否有序
        if (root == null) {
            return true;
        }
        last = null;
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!dfs(node.left)) {
            return false;
        }
        if (last != null && last.val >= node.val) {
            return false;
        }
        last = node;
        if (!dfs(node.right)) {
            return false;
        }
        return true;
    }


}
