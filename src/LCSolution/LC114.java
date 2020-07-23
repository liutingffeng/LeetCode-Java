package LCSolution;

import java.util.*;

public class LC114 {

    class Solution {
//        public void flatten(LCSolution.TreeNode root) {
//            if (root == null)
//                return;
//            flatten(root.left);
//            flatten(root.right);
//            LCSolution.TreeNode temp = root.right;
//            root.right = root.left;
//            root.left = null;
//            //将直的右子树接到左子树最后
//            while (root.right!=null)
//                root = root.right;
//
//            root.right = temp;
//        }

        //前序遍历
//        public void flatten(TreeNode root) {
//            if (root == null)
//                return;
//            Deque<TreeNode> stack = new ArrayDeque<>();
//            stack.push(root);
//            while (!stack.isEmpty()){
//                TreeNode cur = stack.pop();
//                System.out.println(cur.val);
//                if (cur.right!=null)
//                    stack.push(cur.right);
//                if (cur.left!=null)
//                    stack.push(cur.left);
//                cur.right = stack.peek();
//                cur.left = null;
//            }
//        }

        //递归
//        public void flatten(TreeNode root) {
//            if (root == null)
//                return;
//
//            flatten(root.left);
//            flatten(root.right);
//
//            //
//            TreeNode left_tail = root.left;
//            while (left_tail!=null && left_tail.right!=null){
//                left_tail = left_tail.right;
//            }
//            if (left_tail!=null){
//                left_tail.right = root.right;
//                root.right = root.left;
//                root.left = null;
//            }
//
//        }

        public void flatten(TreeNode root) {
            if (root == null)
                return;

            Deque<TreeNode> stack = new LinkedList<>();
            stack.addLast(root);
            TreeNode pre = null;
            while (!stack.isEmpty()){
                TreeNode cur = stack.pollLast();
                if (cur!=null){
                    if (cur.right!=null)
                        stack.addLast(cur.right);
                    if (cur.left!=null)
                        stack.addLast(cur.left);
                    stack.addLast(cur);
                    stack.addLast(null); //标识位
                }
                else { // 代表当前节点已访问过，开始执行处理流程
                    cur = stack.pollLast();
                    if (cur == root){
                        pre = cur;
                    }
                    else {
                        pre.right = cur;
                        pre.left = null;
                        pre = cur;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new LC114().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        solution.flatten(root);
    }
}
