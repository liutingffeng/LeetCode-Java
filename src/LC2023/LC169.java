package LC2023;

public class LC169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((1 ^ 1));
    }

}
