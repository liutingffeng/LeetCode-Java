package LCSolution;

public class LC538 {

    class Solution {
        int num;
        public TreeNode convertBST(TreeNode root) {
            if (root == null)
                return null;
            convertBST(root.right);
            root.val +=num;
            num +=root.val;
            convertBST(root.left);
            return root;
        }


    }
}
