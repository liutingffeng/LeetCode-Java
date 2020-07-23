package LCJZSolution;

import java.util.HashMap;
import java.util.Map;

public class LCJz055II {

    class Solution {
        //后序遍历+剪枝  left ->right ->root
        public boolean isBalanced(TreeNode root) {
            return func(root)!=-1;
        }

        public int func(TreeNode root){
            if (root == null)
                return 0;
            int lDepth = func(root.left);
            if (lDepth == -1)
                return -1;
            int rDepth = func(root.right);
            if (rDepth == -1)
                return -1;
            if (Math.abs(lDepth-rDepth)>1)
                return -1;
            return Math.max(lDepth, rDepth)+1;
        }
    }
}
