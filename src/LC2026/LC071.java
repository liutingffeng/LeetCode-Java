package LC2026;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC071 {

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] splitStr = path.split("/");
        for (String str : splitStr) {
            if (str == null || str.isEmpty())
                continue;
            if (".".equals(str))
                continue;
            if ("..".equals(str)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
                continue;
            }
            deque.addLast(str);
        }

        StringBuilder res = new StringBuilder("/");
        while (!deque.isEmpty()) {
            boolean isLast = deque.size() == 1;
            res.append(deque.pollFirst());
            if (!isLast) {
                res.append("/");
            }
        }
        return res.toString();
    }

}
