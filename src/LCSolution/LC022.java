package LCSolution;

import java.util.*;

public class LC022 {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            recusion(res, new StringBuilder(), n, n);
            return res;
        }

        private void recusion(List<String> res , StringBuilder sb, int ln, int rn){
            if (ln<0 || rn<0 || ln>rn)
                return;
            if (ln == 0 && rn == 0){
                res.add(sb.toString());
                return;
            }

            recusion(res, sb.append('('), ln-1, rn);
            sb.deleteCharAt(sb.length()-1);
            recusion(res, sb.append(')'), ln, rn-1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
