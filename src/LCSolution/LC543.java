package LCSolution;

public class LC543 {

    class Solution {
//        public int diameterOfBinaryTree(LCSolution.TreeNode root) {
//            if (root == null)
//                return 0;
//            return helper(root)[0]-2;
//        }
//
//        //l[0] 最长 l[1] 穿过
//        public int[] helper(LCSolution.TreeNode root){
//            if (root == null || root.left==null)
//                return new int[2];
//
//            int[] left = helper(root.left);
//            int[] right = helper(root.right);
//            int[] cur = new int[2];
//            int curLength = 2 + left[1] + right[1];
//            cur[0] = Math.max(left[0],Math.max(right[0],curLength));
//            cur[1] = Math.max(left[1],right[1])+1;
//            return cur;
//
//        }

        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;
            maxDeep(root);
            return max;
        }

        public int maxDeep(TreeNode root){
            if (root == null)
                return 0;

            int leftDeep = root.left == null ? 0:maxDeep(root.left)+1;
            int rightDeep = root.right == null ? 0:maxDeep(root.right)+1;
            max = Math.max(max, leftDeep+rightDeep);
            return Math.max(leftDeep, rightDeep);
        }
    }
}
