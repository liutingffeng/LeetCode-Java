package LC200;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public class LC272SC {

    List<Integer> res = new LinkedList<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        dfs(root, target, k);
        return res;
    }

    private void dfs(TreeNode root, double target, int k) {
        if (root == null)
            return;
        dfs(root.left, target, k);
        if (res.size() < k) {
            res.add(root.val);
        } else {
            if (Math.abs(root.val - target) < Math.abs(res.get(0) - target)) {
                res.add(root.val);
                res.remove(0);
            } else {
                return;
            }
        }
        dfs(root.right, target, k);
    }

    public static void main(String[] args) {
    }
}
