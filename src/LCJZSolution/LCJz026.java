package LCJZSolution;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class LCJz026 {

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null)
                return false;
            if (A.val == B.val)
                if (subStruc(A, B))
                    return true;
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean subStruc(TreeNode A ,TreeNode B){
            if (B == null)
                return true;
            if (A == null)
                return false;
            if (A.val != B.val)
                return false;
            return subStruc(A.left, B.left) && subStruc(A.right, B.right);
        }
    }
}
