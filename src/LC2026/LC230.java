package LC2026;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC230 {


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

    private int k;
    private int res;
    private int index;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.index = 0;
        midOrder(root);
        return res;
    }

    private boolean midOrder(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (midOrder(node.left)) {
            return true;
        }
        if (++index == k) {
            res = node.val;
            return true;
        }
        return midOrder(node.right);
    }

}
