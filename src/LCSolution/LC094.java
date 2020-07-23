package LCSolution;

import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LC094 {


    class Solution {
//        public List<Integer> inorderTraversal(LCSolution.TreeNode root) {
//            List<Integer> res = new ArrayList<>();
//            func(root, res);
//            return res;
//        }
//
//        //中序遍历
//        private void func(LCSolution.TreeNode root,List<Integer> res){
//            if (root == null)
//                return;
//
//            func(root.left, res);
//            res.add(root.val);
//            func(root.right, res);
//        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while (cur!= null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                else {
                    cur = stack.pop();
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
            return res;
        }
    }
}
