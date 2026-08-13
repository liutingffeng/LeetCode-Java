import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author liutingfeng
 * @Date 2026/7/27 20:06
 */
public class CodeTest {

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            this.val = v;
        }
    }

    public static void printTree(TreeNode root) {
        //   0 11111111111111111111111
        // 0 1
        // 0 11


        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pollFirst();
                System.out.printf("  ");
                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
            }
            System.out.println("==============================");
        }
    }


    public static void main(String[] args) {
        /**
         *         1
         *      2    3
         *   4    5     7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        printTree(root);
    }
}
