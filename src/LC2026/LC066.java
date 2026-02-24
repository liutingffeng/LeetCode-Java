package LC2026;

public class LC066 {

    public int[] plusOne(int[] digits) {
        int next = 1;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            int cur = digits[i] + next;
            if (cur < 10) {
                digits[i] = cur;
                return digits;
            }
            digits[i] = cur % 10;
            next = cur / 10;
        }
        if (next > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i+1] = digits[i];
            }
            return res;
        }
        return digits;
    }


}
