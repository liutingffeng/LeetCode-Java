package LCSolution;

public class LC450 {

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;

            //待删除节点在左子树
            if (key < root.val){
                root.left = deleteNode(root.left, key);
                return root;
            }
            //待删除节点在右子树
            else if (key > root.val){
                root.right = deleteNode(root.right, key);
                return root;
            }
            else {
                //root 为待删除节点
                //删除节点左子树为空
                if (root.left == null){
                    return root.right;
                }
                else if (root.right == null){
                    return root.left;
                }
                else {
                    // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                    TreeNode successor = findMin(root.right);
                    successor.right = deleteMin(root.right);
                    successor.left = root.left;
                    return successor;
                }
            }
        }

        private TreeNode findMin(TreeNode root){
            if (root == null)
                return null;
            while (root.left!=null){
                root = root.left;
            }
            return root;
        }

        private TreeNode deleteMin(TreeNode root){
            if (root.left == null)
                return root.right;
            root.left = deleteMin(root.left);
            return root;
        }
    }
}
