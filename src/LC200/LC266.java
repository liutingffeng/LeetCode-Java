package LC200;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 *
 */
public class LC266 {

    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                continue;
            }
            set.add(c);
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
    }
}
