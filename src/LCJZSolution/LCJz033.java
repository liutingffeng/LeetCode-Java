package LCJZSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LCJz033 {

    class Solution {
        //后序遍历 left->right->root
        //后序遍历的逆序  root->right->left
        //单调栈
        public boolean verifyPostorder(int[] postorder) {
            Deque<Integer> deque = new ArrayDeque<>();
            int preNum = Integer.MAX_VALUE;
            for (int i=postorder.length-1;i>=0;i--){
                //如果当前值大于根值，则不是二分搜索树
                if (postorder[i]>preNum)
                    return false;
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                while (!deque.isEmpty() && postorder[i] < deque.peekFirst()){
                    preNum = deque.pollFirst();
                }
                deque.push(postorder[i]);
            }
            return true;
        }
    }
}
