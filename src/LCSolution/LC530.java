package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC530 {

    class Solution {
        //给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
        //中序遍历
        public int getMinimumDifference(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            int preValue = -1;
            int res = Integer.MAX_VALUE;
            while (root!=null || !deque.isEmpty()){
                while (root!=null){
                    deque.addLast(root);
                    root = root.left;
                }
                root = deque.pollLast();
                if (preValue < 0){
                    preValue = root.val;
                }
                else {
                    res = Math.min(res, root.val-preValue);
                    preValue = root.val;
                }
                root = root.right;
            }
            return res;
        }
    }
}
