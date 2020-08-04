package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC095 {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    class Solution {


        public List<TreeNode> generateTrees(int n) {
            if (n == 0)
                return new ArrayList<>();
            return recusion(1, n);
        }

        private List<TreeNode> recusion(int l,int r){
            List<TreeNode> res = new ArrayList<>();
            if (l>r) {
                res.add(null);
                return res;
            }
            if (l==r) {
                res.add(new TreeNode(l));
                return res;
            }


            for (int i = l; i <=r ; i++) {
                TreeNode cur ;
                List<TreeNode> leftcol = recusion(l,i-1);
                List<TreeNode> rightcol = recusion(i+1, r);
                for (TreeNode left : leftcol)
                    for (TreeNode right : rightcol){
                        cur = new TreeNode(i);
                        cur.left = left;
                        cur.right = right;
                        res.add(cur);
                    }
            }
            return res;
        }
    }
}
