package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC449 {

    public class Codec {

        private void preorder(TreeNode root, List<String> list){
            if (root == null)
                return;
            list.add(String.valueOf(root.val));
            preorder(root.left, list);
            preorder(root.right, list);
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";
            List<String> list = new ArrayList<>();
            preorder(root, list);
            StringBuilder sb = new StringBuilder();
            for (String str:list){
                sb.append(str).append(' ');
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0)
                return null;
            String[] strlist = data.split(" ");
            int[] nums = new int[strlist.length];
            for (int i = 0; i < strlist.length; i++) {
                nums[i] = Integer.valueOf(strlist[i]);
            }
            return helper(nums, 0, nums.length-1);
        }

        private TreeNode helper(int[] nums,int l,int r){
            if (l>r)
                return null;

            int rootval = nums[l];
            TreeNode root = new TreeNode(rootval);
            //
            int rstart = l;
            for (int i = l+1; i <=r; i++) {
                if (nums[i]>rootval)
                    break;
                rstart++;
            }
            root.left = helper(nums, l+1, rstart);
            root.right = helper(nums, rstart+1, r);
            return root;
        }

        private String num2Str(int val){
            StringBuilder sb = new StringBuilder();
            while (val!=0){
                sb.append(val%10);
                val /=10;
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String s = new LC449().new Codec().num2Str(12345);
        System.out.println(s);
    }
}
