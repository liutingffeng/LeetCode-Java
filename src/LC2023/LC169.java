package LC2023;

public class LC169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0)
                res = num;
            votes += num == res ? 1 : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((1 ^ 1));
    }

}
