package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC105 {

    class Solution {
//        public TreeNode buildTree(int[] preorder, int[] inorder) {
//            if (preorder == null || preorder.length == 0)
//                return null;
//            return func(preorder, inorder, 0,preorder.length-1, 0, preorder.length-1);
//        }

        //[lino,mid,rino]
        //mid 是当前 inorder 中 root 的位置
        // preorder: [root, [left], [right]]
//        private TreeNode func(int[] preorder, int[] inorder,int lpre,int rpre,int lino,int rino){
//
//            if (lpre>rpre || lino>rino)
//                return null;
//            int root = preorder[lpre];
//            int mid = rino;
//            for (int i=lino;i<=rino;i++) {
//                if (root == inorder[i]){
//                    mid = i;
//                    break;
//                }
//            }
//            TreeNode cur = new TreeNode(root);
//            int len = mid-lino;
//            cur.left = func(preorder, inorder, lpre+1,lpre+len,lino,mid-1);
//            cur.right = func(preorder, inorder, lpre+len+1,rpre,mid+1,rino);
//            return cur;
//        }

        /*
         从前序与中序遍历序列构造二叉树
         前序遍历 preorder = [3,9,20,15,7]
         中序遍历 inorder = [9,3,15,20,7]
    3
   / \
  9  20
    /  \
   15   7
         */
        Map<Integer,Integer> map;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0)
                return null;
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return func(preorder, inorder, 0, inorder.length-1, 0);
        }

        private TreeNode func (int[] preorder, int[] inorder,int il,int ir,int rootIndex){
            if (il > ir)
                return null;
            if (il>=ir){
                return new TreeNode(inorder[il]);
            }

            int rVal = preorder[rootIndex];
            TreeNode root = new TreeNode(rVal);
            // 在中序遍历中找根节点的值
//            int rIno = il;
//            for (int i = il; i <= ir; i++) {
//                if (inorder[i] == rVal){
//                    rIno = i;
//                    break;
//                }
//            }
            int rIno = map.get(rVal);

            root.left = func(preorder, inorder, il, rIno-1, rootIndex+1);
            root.right = func(preorder, inorder, rIno+1, ir, rootIndex+rIno-il+1);
            return root;
        }
    }
}
