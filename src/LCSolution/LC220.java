package LCSolution;

import org.omg.CORBA.IntHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LC220 {

    class Solution {

//        //（二叉搜索树） 平衡二叉树
//        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//
//            TreeSet<Long> set = new TreeSet<>();
//            for (int i = 0; i < nums.length; i++) {
//
//                if (i>k){
//                    set.remove((long)nums[i-k-1]);
//                }
//                /*这个方法的前提是对 TreeSet 这个数据结构要了解。其中有一个方法 public E ceiling(E e) ，
//                返回 treeSet 中大于等于 e 的元素中最小的元素，如果没有大于等于 e 的元素就返回 null。
//                 */
//                Long low = set.ceiling((long) nums[i]-t);
//                if (low != null && low.compareTo((long)nums[i]+t)<=0){
//                    return true;
//                }
//                set.add((long) nums[i]);
//            }
//            return false;
//        }

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (t<0)
                return false;
            Map<Integer,Integer> map = new HashMap<>();
            // 每个桶中存储的元素个数
            int w = t+1;
            for (int i = 0; i < nums.length; i++) {

                if (i>k){
                    map.remove(getId(nums[i-k-1], w));
                }

                // 得到元素所在的桶的id
                int id = getId(nums[i],w);
                // 桶中已经有元素了
                if (map.containsKey(id)){
                    return true;
                }

                // 相邻的桶
                if (map.containsKey(id-1) && (long)nums[i]-map.get(id-1)<=t)
                    return true;
                if (map.containsKey(id+1) && (long)map.get(id+1)-nums[i]<=t)
                    return true;

                map.put(id, nums[i]);
            }
            return false;
        }

        private int getId (int num , int w){
            if (num >= 0){
                return num/w;
            }
            else {
                return (num+1)/w-1;
            }
        }
    }

    public static void main(String[] args) {
        boolean b = new LC220().new Solution().containsNearbyAlmostDuplicate(new int[]{0, 2147483647}, 1, 2147483647);
        System.out.println(b);
    }
}
