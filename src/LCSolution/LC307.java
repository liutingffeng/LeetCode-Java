package LCSolution;

import java.util.HashMap;
import java.util.Map;

public class LC307 {

    //线段树
    class NumArray {
        int[] tree;
        int[] nums;
        int n;

        public NumArray(int[] nums) {
            n = nums.length;
            if (n==0)
                return;
            this.nums = nums;
            tree = new int[n*4];
            buildTree(0,0,n-1);
        }

        private void buildTree(int i, int left, int right) {
            if (left == right){
                tree[i] = nums[left];
                return;
            }

            //
            int mid = left + (right-left)/2;
            int leftchild = (i<<1)+1;
            int rightchild = (i<<1)+2;
            buildTree(leftchild, left,mid);
            buildTree(rightchild, mid+1, right);
            tree[i] = tree[leftchild] + tree[rightchild];
        }


        public void update(int i, int val) {
            updateTree(i,0,val,0,n-1);
        }

        private void updateTree(int i, int node, int val, int l, int r) {
            if (l>r)
                return;
            if (l == r){
                nums[i] = val;
                tree[node] = val;
                return;
            }
            int mid = l +(r-l)/2;
            int leftchild = (node<<1)+1;
            int rightchild = (node<<1)+2;
            if (i>=l && i<=mid) {
                updateTree(i, leftchild, val, l, mid);
            }
            else {
                updateTree(i, rightchild, val, mid + 1, r);
            }
            tree[node] = tree[leftchild]+tree[rightchild];
        }

        public int sumRange(int i, int j) {
            return query(0,0,n-1,i,j);
        }

        private int query(int node, int l, int r, int i, int j) {
            if (i>j || j<l || i>r)
                return 0;
            if (l == r){
                return tree[node];
            }
            if (i<=l && r<=j)
                return tree[node];


            int mid = l +(r-l)/2;
            int leftchild = (node<<1)+1;
            int rightchild = (node<<1)+2;
            if (j<=mid){
                return query(leftchild, l, mid, i, j);
            }
            else if (i>mid){
                return query(rightchild, mid+1, r, i, j);
            }
            else {
                return query(leftchild, l, mid, i, mid)
                        + query(rightchild, mid+1, r, mid+1, j);
            }
        }
    }
}
