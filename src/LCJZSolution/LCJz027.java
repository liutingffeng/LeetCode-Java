package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz027 {

    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null)
                return root;
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            mirrorTree(root.left);
            mirrorTree(root.right);
            return root;
        }
    }
}
