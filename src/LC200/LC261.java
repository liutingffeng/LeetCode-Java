package LC200;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class LC261 {

    class TreeNode {
        private int val;

        private List<TreeNode> next;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        //
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < edges.length; i++) {
            int[] cur = edges[i];
            TreeNode left = nodes[cur[0]];
            if (left == null) {
                nodes[cur[0]] = new TreeNode(cur[0]);
            }
            TreeNode right = nodes[cur[1]];
            if (right == null) {
                nodes[cur[1]] = new TreeNode(cur[1]);
            }
            if (left.next == null) {
                left.next = new ArrayList<>();
            }
            left.next.add(right);
        }
        int[] foot = new int[n];
        TreeNode root = nodes[0];


    }

    public static void main(String[] args) {
    }
}
