package LCSolution;

import java.util.*;

public class LC297 {

    //前序遍历 root->left->right
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";

            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode cur = stack.pop();
                if (cur!=null){
                    stack.push(cur.right);
                    stack.push(cur.left);
                    res.add(cur.val);
                }
                else {
                    res.add(null);
                }
            }
            return res.toString();
        }

        //前序遍历用递归


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "")
                return null;

            String data_sub= data.substring(1, data.length() - 1);
            String[] data_array = data_sub.split(",");
            String[] data_trim = new String[data_array.length];
            for (int i=0;i<data_array.length;i++){
                data_trim[i] = data_array[i].trim();
            }
            List<String> data_list = new LinkedList<>(Arrays.asList(data_trim));
            return deser_helper(data_list);
        }

        private TreeNode deser_helper(List<String> list){
            if (list.get(0).equals("null")) {
                list.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = deser_helper(list);
            root.right = deser_helper(list);
            return root;
        }
    }


    public static void main(String[] args) {
        String s = "[1, 2, 4, null, null, 5, 6, null, null, null, 3, null, 7, null, null]";
        System.out.println(s.substring(1, s.length()-1).trim());

//        LCSolution.TreeNode root = new LCSolution.TreeNode(1);
//        root.left = new LCSolution.TreeNode(2);
//        root.right = new LCSolution.TreeNode(3);
//        LCSolution.TreeNode left = root.left;
//        LCSolution.TreeNode right = root.right;
//        left.left = new LCSolution.TreeNode(4);
//        right.right = new LCSolution.TreeNode(7);
//        left.right = new LCSolution.TreeNode(5);
//        right = left.right;
//        right.left = new LCSolution.TreeNode(6);
//
//        List<Integer> res = new ArrayList<>();
//        Stack<LCSolution.TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            LCSolution.TreeNode cur = stack.pop();
//            if (cur!=null){
//                stack.push(cur.right);
//                stack.push(cur.left);
//                res.add(cur.val);
//            }
//            else {
//                res.add(null);
//            }
//        }
//        System.out.println(res.toString());
    }

}
