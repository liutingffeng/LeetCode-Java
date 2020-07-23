package LCSolution;

public class LC437 {

    class Solution {
        public int pathSum(TreeNode root, int sum) {
            if (root == null)
                return 0;
            return countPath(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
        }

        public int countPath(TreeNode root,int sum){
            if (root == null)
                return 0;

            sum = sum - root.val;
            return (sum == 0 ? 1:0)+countPath(root.left, sum)+countPath(root.right, sum);
        }

        //前缀和
    }
}
