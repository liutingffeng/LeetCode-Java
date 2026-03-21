package LC2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LC151 {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        List<String> stringList = new ArrayList<>(Arrays.asList(s1));
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.isEmpty())
                iterator.remove();
        }
        int i = 0, j = stringList.size() - 1;
        while (i < j) {
            String temp = stringList.get(i);
            stringList.set(i, stringList.get(j));
            stringList.set(j, temp);
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < stringList.size(); k++) {
            sb.append(stringList.get(k));
            if (k != (stringList.size() - 1)) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new LC151().reverseWords("  hello world  ");
    }
}
