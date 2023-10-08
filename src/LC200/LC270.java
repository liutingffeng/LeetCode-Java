package LC200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 *
 */
public class LC270 {

    public int closestValue(TreeNode root, double target) {

        double diff = Math.abs(root.val - target);
        int res = root.val;
        // bfs
        while (root != null) {
            if (Math.abs(root.val - target) <= diff) {
                res = root.val;
                diff = Math.abs(root.val - target);
            }
            if (root.val > target)
                root = root.left;
            else
                root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
