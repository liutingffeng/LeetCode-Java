package LCSolution;

public class LC222 {

    class Solution {
        /**
         完全二叉树的高度可以直接通过不断地访问左子树就可以获取
         判断左右子树的高度:
         如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
         如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
         **/
//        public int countNodes(TreeNode root) {
//            if (root == null)
//                return 0;
//            return countNodes(root.left)+countNodes(root.right)+1;
//        }

//          public int countNodes(TreeNode root) {
//              if (root == null)
//                  return 0;
//              int count = 0;
//              int leftdepth = countdepth(root.left);
//              int rightdepth = countdepth(root.right);
//              // 右子树是完全二叉树
//              if (leftdepth>rightdepth){
//                  count += (1<<rightdepth)-1;
//                  count += countNodes(root.left);
//              }
//              else {
//                  count += (1<<leftdepth)-1;
//                  count += countNodes(root.right);
//              }
//
//              return count+1;
//          }

          private int countdepth(TreeNode root){
              int depth = 0;
              while (root!=null){
                  root = root.left;
                  depth++;
              }
              return depth;
          }

          /*
          利用完全二叉树的性质，二分查找最后一层
           */
          public int countNodes(TreeNode root) {
              if (root == null)
                  return 0;
              // 二叉树的深度
              int depth = countdepth(root);
              // 倒数第二层的深度
              int pre_depth = depth-1;

              // 二分查找
              int l = 1;
              int r = (1<<pre_depth);
              while (l<=r){
                  int mid = l + (r-l)/2;
                  // 节点存在
                  if (isExit(root,mid,pre_depth)){
                      l = mid +1;
                  }
                  else {
                      r = mid -1;
                  }
              }
              // l-1 就是最后一层的节点数
              return (1<<pre_depth)+l-2;
          }

        private boolean isExit(TreeNode root, int index, int pre_depth) {
              while (pre_depth>0){
                  // 分界线
                  int mid = (1<<pre_depth-1);
                  // 在右子树
                  if (index>mid){
                      index = index - mid;
                      root = root.right;
                  }
                  else {
                      root = root.left;
                  }
                  pre_depth -- ;
              }
              return root != null;
        }
    }
}
