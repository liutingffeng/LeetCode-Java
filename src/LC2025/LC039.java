package LC2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC039 {

    private static List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        recursion(candidates, 0, target, temp);
        return res;
    }

    private void recursion(int[] candidates, int index, int sum, List<Integer> temp) {
        if (index >= candidates.length)
            return;

        if (sum < 0)
            return;

        if (sum == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            recursion(candidates, i, sum - candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{2,3,6,7};
        new LC039().combinationSum(x, 7);
    }
}
