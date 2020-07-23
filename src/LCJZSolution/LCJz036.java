package LCJZSolution;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class LCJz036 {

    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null)
                return null;
            Deque<Node> stack = new LinkedList<>();
            Node dummy = new Node();
            Node pre = dummy;
            while (!stack.isEmpty() || root!=null){
                if (root!=null){
                    stack.push(root);
                    root = root.left;
                }
                else {
                    Node cur = stack.pop();
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                    root = cur.right;
                }
            }
            Node head = dummy.right;
            head.left = pre;
            pre.right = head;
            return head;
        }
    }
}
