package LCSolution;

import java.util.*;

public class LC098 {

    class Solution {

        //递归
//        public boolean isValidBST(LCSolution.TreeNode root) {
//            return func(root, null, null);
//        }
//
//        private boolean func(LCSolution.TreeNode node,Integer lower,Integer upper){
//            if (node == null)
//                return true;
//
//            int val = node.val;
//            if (lower!=null && val<=lower )
//                return false;
//            if (upper!=null && val>=upper)
//                return false;
//
//            return func(node.left, lower, val) && func(node.right, val, upper);
//        }

        //中序遍历升序
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            long preValue = Long.MIN_VALUE;
            while (root!=null || !stack.isEmpty()){
                if (root!=null){
                    stack.push(root);
                    root = root.left;
                }
                else {
                    root = stack.pop();
                    if (preValue >= root.val)
                        return false;
                    preValue = root.val;
                    root = root.right;
                }
            }
            return true;
        }
    }
}
