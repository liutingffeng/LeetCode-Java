package LCSolution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC337 {

    class Solution {
        Map<TreeNode,Integer> memo_map = new HashMap<>();

//        public int rob(LCSolution.TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//
//            if (memo_map.containsKey(root))
//                return memo_map.get(root);
//
//            LCSolution.TreeNode left = root.left;
//            LCSolution.TreeNode right = root.right;
//            //当前节点偷盗
//            int money = root.val;
//            if (left!=null){
//                money += (left.left == null ? 0:rob(left.left))+(left.right==null? 0:rob(left.right));
//            }
//            if (right!=null){
//                money += (right.left==null? 0:rob(right.left))+(right.right==null? 0:rob(right.right));
//            }
//            int curValue = Math.max(rob(root.left)+rob(root.right), money);
//            memo_map.put(root, curValue);
//            return curValue;
//        }
//    }


        public int rob(TreeNode root) {
            int[] res = robInterval(root);
            // res[0] 表示不偷当前节点 res表示偷
            return Math.max(res[0],res[1]);
        }

        private int[] robInterval(TreeNode root){
            if (root == null)
                return new int[2];

            int[] res = new int[2];

            int[] left = robInterval(root.left);
            int[] right = robInterval(root.right);

            res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
            res[1] = left[0]+right[0]+root.val;
            return res;
        }
    }

    @Test
    public void test(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(null, 1);
        System.out.println(map.get(null));
    }
}
