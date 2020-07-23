package LCSolution;

import java.util.*;

public class LC144 {

    static class Solution {
        //前序遍历非递归
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null)
                return null;
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            while (!deque.isEmpty()){
                root = deque.pollLast();
                res.add(root.val);
                if (root.right!=null){
                    deque.addLast(root.right);
                }
                if (root.left!=null){
                    deque.addLast(root.left);
                }
            }
            return res;
        }

        //中序遍历
//        public List<Integer> preorderTraversal(LCSolution.TreeNode root) {
//            if (root == null)
//                return null;
//            List<Integer> res = new ArrayList<>();
//            Deque<LCSolution.TreeNode> deque = new ArrayDeque<>();
//            while (!deque.isEmpty() || root != null){
//                while (root!=null){
//                    deque.addLast(root);
//                    root = root.left;
//                }
//                root = deque.pollLast();
//                res.add(root.val);
//                root = root.right;
//            }
//            return res;
//        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new Solution().preorderTraversal(root);
    }
}
