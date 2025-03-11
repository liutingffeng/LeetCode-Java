package LCSolution;


import java.util.HashMap;
import java.util.Map;

public class LC437 {

    class Solution {

        // 路径总和
        public int pathSum(TreeNode root, int sum) {
            if (root == null)
                return 0;
            return countPath(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
        }

        /*
        计算从根节点出发有多少路径和为sum
         */
        public int countPath(TreeNode root,int sum){
            if (root == null)
                return 0;

            sum = sum - root.val;
            return (sum == 0 ? 1:0)+countPath(root.left, sum)+countPath(root.right, sum);
        }

//        int count;
//        Map<Integer, Integer> map;
//        //前缀和
//        public int pathSum(TreeNode root, int sum) {
//            map = new HashMap<>();
//            map.put(0, 1);
//            dfs(root, sum, 0);
//            return count;
//        }
//
//        private void dfs(TreeNode root,int sum,int rootval){
//            if (root == null)
//                return;
//
//            rootval = rootval+root.val;
//            count += map.getOrDefault(rootval-sum, 0);
//            map.put(rootval, map.getOrDefault(rootval, 0)+1);
//            dfs(root.left, sum, rootval);
//            dfs(root.right, sum, rootval);
//
//            // 回溯
//            map.put(rootval, map.get(rootval)-1);
//        }
    }
}
