package LCSolution;

import java.util.ArrayList;
import java.util.List;

public class LC315I {

    class BSTNode{
        int val;
        int count;
        BSTNode left;
        BSTNode right;

        public BSTNode(int val) {
            this.val = val;
        }
    }

    class Solution {

        //二叉搜索树
        public List<Integer> countSmaller(int[] nums) {
            int[] res = new int[nums.length];
            BSTNode root = null;
            for (int i = nums.length-1; i >=0 ; i--) {
                root = insertBST(root, new BSTNode(nums[i]), res, i);
            }
            List<Integer> result = new ArrayList<>();
            for (int i:res){
                result.add(i);
            }
            return result;
        }

        private BSTNode insertBST(BSTNode root,BSTNode node,int[] res ,int i){
            if (root == null){
                root = node;
                return root;
            }

            //如果待插入的数比较小，或者相等的时候，就往左子树中插入,且根节点的count要加1
            if (node.val<root.val){
                root.count++;
                root.left = insertBST(root.left, node, res, i);
            }
            else {
                if (node.val == root.val){
                    res[i] +=root.count;
                }
                else {
                    res[i] +=root.count+1;
                }
                root.right = insertBST(root.right, node, res, i);
            }
            return root;
        }


    }

    public static void main(String[] args) {
        new LC315I().new Solution().countSmaller(new int[]{5,2,6,1});
        int[] arr = new int[]{5,2,6,1};
        for (int i:arr){
            System.out.println(i);
        }
    }
}
