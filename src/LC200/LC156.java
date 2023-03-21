package LC200;

/**
 * 给你一个二叉树的根节点 root ，请你将此二叉树上下翻转，并返回新的根节点。
 *
 * 你可以按下面的步骤翻转一棵二叉树：
 *
 * 原来的左子节点变成新的根节点
 * 原来的根节点变成新的右子节点
 * 原来的右子节点变成新的左子节点
 *
 */
public class LC156 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        // 题目数据保证每个右节点都有一个同级节点（即共享同一父节点的左节点）且不存在子节点。
        TreeNode res = help(root.left, root, root.right);
        root.left = null;
        root.right = null;
        return res;
    }

    private TreeNode help (TreeNode cur, TreeNode newRight, TreeNode newLeft) {
        TreeNode next = cur.left;
        TreeNode t = cur.right;
        cur.right = newRight;
        cur.left = newLeft;
        if (next == null) {
            return cur;
        }
        return help(next, cur, t);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        new LC156().upsideDownBinaryTree(root);
    }
}
