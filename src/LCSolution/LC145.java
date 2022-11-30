package LCSolution;


import java.util.*;

public class LC145 {

    class Solution {

        // Non-Recursive
// Using two stacks, Reverse the Preorder Traversal!
//  前序遍历：root->left->right
//  后序遍历：left->right->root
//  如果把前序遍历变为：root->right->left  再reverse 就是后序


//        // Non-Recursive
//// Using a pre pointer to record the last visted node
//        public List<Integer> postorderTraversal(TreeNode root) {
//            ArrayList<Integer> res = new ArrayList<Integer>();
//            if(root == null)
//                return res;
//
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode pre = null;
//
//            stack.push(root);
//            while (!stack.isEmpty()){
//                TreeNode cur = stack.peek();
//
//                if ((cur.left==null && cur.right==null)//左右子树都为空
//                    || (pre!=null && (pre==cur.left || pre ==cur.right)) //上一个访问的结点为当前结点的子节点时，当前结点出栈
//                   ) {
//                    res.add(cur.val);
//                    pre = cur;
//                    stack.pop();
//                }
//                else {
//                    if (cur.right!=null)
//                        stack.push(cur.right);
//                    if (cur.left!=null)
//                        stack.push(cur.left);
//                }
//            }
//            return res;
//        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null)
                return res;
            Deque<TreeNode> stack = new LinkedList<>();
            stack.addLast(root);
            while (!stack.isEmpty()){
                TreeNode cur = stack.pollLast();
                if (cur!=null){
                    stack.addLast(cur);
                    stack.addLast(null);
                    if (cur.right!=null)
                        stack.addLast(cur.right);
                    if (cur.left!=null)
                        stack.addLast(cur.left);
                }
                else {
                    // 处理节点
                    cur = stack.pollLast();
                    res.add(cur.val);
                }
            }
            return res;
        }
    }
}
