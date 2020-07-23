package LCSolution;

public class LC105 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0)
                return null;
            return func(preorder, inorder, 0,preorder.length-1, 0, preorder.length-1);
        }

        //[lino,mid,rino]
        //mid 是当前 inorder 中 root 的位置
        // preorder: [root, [left], [right]]
        private TreeNode func(int[] preorder, int[] inorder,int lpre,int rpre,int lino,int rino){

            if (lpre>rpre || lino>rino)
                return null;
            int root = preorder[lpre];
            int mid = rino;
            for (int i=lino;i<=rino;i++) {
                if (root == inorder[i]){
                    mid = i;
                    break;
                }
            }
            TreeNode cur = new TreeNode(root);
            int len = mid-lino;
            cur.left = func(preorder, inorder, lpre+1,lpre+len,lino,mid-1);
            cur.right = func(preorder, inorder, lpre+len+1,rpre,mid+1,rino);
            return cur;
        }
    }
}
