package LCSolution;

public class LC129 {

    class Solution {
        private int sum;
        public int sumNumbers(TreeNode root) {
            dfs(root, 0);
            return sum;
        }

        private void dfs(TreeNode root,  int lastSum){
            if (root == null)
                return;
            lastSum = lastSum*10+root.val;
            if (root.left == null && root.right==null){
                sum += lastSum;
                return;
            }

            dfs(root.left, lastSum);
            dfs(root.right, lastSum);
        }
    }
}
