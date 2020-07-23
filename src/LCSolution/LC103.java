package LCSolution;

import java.util.*;

public class LC103 {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            boolean flag = true;  //从左往右
            while (!queue.isEmpty()){
                LinkedList<Integer> temp = new LinkedList<>();
                int count = queue.size();
                TreeNode cur;
                while (count-->0){
                    cur = queue.poll();
                    if (flag){
                        temp.addLast(cur.val);
                    }
                    else {
                        temp.addFirst(cur.val);
                    }
                    if (cur.left!=null)
                        queue.offer(cur.left);
                    if (cur.right!=null)
                        queue.offer(cur.right);
                }
                flag = !flag;
                res.add(temp);
            }
            return res;
        }
    }
}
