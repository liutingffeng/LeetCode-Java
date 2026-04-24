package LC2026;

public class LC006 {

    public String convert(String s, int numRows) {
        StringBuilder[] sbArr = new StringBuilder[numRows];
        int i = 0;
        int row = 0;
        int nextStep = 1;
        while (i < s.length()) {
            if (numRows == 1) {
                nextStep = 0;
            } else if (row == 0) {
                nextStep = 1;
            } else if (row == (numRows - 1)) {
                nextStep = -1;
            }
            if (sbArr[row] == null) {
                sbArr[row] = new StringBuilder();
            }
            sbArr[row].append(s.charAt(i));
            row += nextStep;
            i++;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbArr) {
            if (sb != null) {
                res.append(sb);
            }
        }
        return res.toString();
    }


}
