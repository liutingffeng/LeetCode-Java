package LC200;

/**
 * 
 *
 */
public class LC250 {

    static class Ret {
        boolean isSame;
        Integer value;

        public Ret(boolean isSame, Integer value) {
            this.isSame = isSame;
            this.value = value;
        }
    }

    private int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private Ret dfs(TreeNode node) {
        if (node == null) {
            return new Ret(true, null);
        }
        if (node.left == null && node.right == null) {
            res ++;
            return new Ret(true, node.val);
        }

        Ret left = dfs(node.left);
        Ret right = dfs(node.right);
        if (left.isSame && right.isSame) {
            if (left.value == null) {
                if (node.val == right.value) {
                    res ++;
                    return new Ret(true, node.val);
                } else {
                    return new Ret(false, null);
                }
            } else if (right.value == null) {
                if (node.val == left.value) {
                    res ++;
                    return new Ret(true, node.val);
                } else {
                    return new Ret(false, null);
                }
            } else {
                if (node.val == left.value && node.val == right.value) {
                    res ++;
                    return new Ret(true, node.val);
                } else {
                    return new Ret(false, null);
                }
            }
        }
        return new Ret(false, null);
    }

    public static void main(String[] args) {
    }
}
