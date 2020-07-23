package LCSolution;

public class LC235 {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return root;

            // 改进
            //if((root.val - p.val)*(root.val - q.val) <= 0)

            if (root.val == p.val || root.val == q.val || (root.val < q.val && root.val > p.val) ||
                    (root.val > q.val && root.val < p.val))
                return root;
            else if (root.val < q.val && root.val < p.val)
                return lowestCommonAncestor(root.right, p, q);
            else
                return lowestCommonAncestor(root.left, p, q);
        }
    }
}
