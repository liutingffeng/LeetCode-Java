package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC230 {

    class Solution {
        //给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
        //中序遍历
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            int count = 0;
            while (root!=null || !deque.isEmpty()){
                while (root!=null){
                    deque.addLast(root);
                    root = root.left;
                }
                root = deque.pollLast();
                count++;
                if (count == k)
                    return root.val;
                root = root.right;
            }
            return -1;
        }
    }
}
