package LC2026;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= -1; j--) {
                if (j == -1 || dp[j]) {
                    String sub = s.substring(j + 1, i + 1);
                    if (set.contains(sub)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        String a = "abc";
        HashSet<String> set = new HashSet<>();
        set.add(a);

        String b = "abc";
        System.out.println(set.contains(b));
    }

}
