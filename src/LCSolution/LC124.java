package LCSolution;

public class LC124 {

    class Solution {
        private int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
/**
 对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
 1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
 2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径

 二：当前节点作为父节点的一个子节点
 和父节点连接的话则需取【单端的最大值】
 1.只有当前节点
 2.当前节点+左子树
 3.当前节点+右子书
 这三种情况的最大值
 **/
            func(root);
            return res;
        }

        int func(TreeNode root){
            if (root == null)
                return 0;

            int curValue = root.val;
            int leftSum = func(root.left);
            int rightSum = func(root.right);
            curValue+=leftSum<0 ? 0:leftSum;
            curValue+=rightSum<0? 0:rightSum;

            res = Math.max(res, curValue);
            return Math.max(root.val,Math.max(root.val+leftSum, root.val+rightSum));
        }
    }
}
