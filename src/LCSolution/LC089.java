package LCSolution;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC089 {

    class Solution {

        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            int head = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = res.size()-1; j >=0 ; j--) {
                    res.add(res.get(j)+head);
                }
                head <<=1;
            }
            return res;
        }
    }
}
