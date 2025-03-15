package LC2025;

public class LC538 {
    public TreeNode convertBST(TreeNode root) {
        recursion(root, 0);
        return root;
    }

    private int recursion(TreeNode current, int pValue) {
        if (current == null)
            return pValue;
        int rightSum = recursion(current.right, pValue);
        current.val = current.val + rightSum;
        int leftSum = recursion(current.left, current.val);
        return leftSum;
    }
}
