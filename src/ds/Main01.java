package ds;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author liutingfeng
 * @Date 2026/8/2 15:31
 */
public class Main01 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(solve(a, b));
//        }
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.printf("%.6f\n", solve(a, b));
//        float a = 0.0068965517f;
//        String s = String.valueOf(a);
//        System.out.println(String.valueOf(a));
//        if (s.charAt(9) - '0' > 4) {
//            String b = s.substring(0, 8);
//            System.out.println(b);
//
//            float v = Float.parseFloat(b);
//            System.out.println((v * 1000000 + 1)/ 1000000);
//        }
    }

    public static float solve(String s1, String s2) {
        long a = Long.parseLong(s1);
        long b = Long.parseLong(s2);

        int count = 0;
        if (a > b) {
            long t = a;
            a = b;
            b = t;
        }
        long sum = (b - a) * (b - a + 1) / 2;
        Set<Long> hasCaclute = new HashSet<>();
        for (long i = a; i <= b; i++) {
            if (hasCaclute.contains(i)) {
                continue;
            }
            Set<Long> curDigits = digits(i);
            Set<Long> tempList = new HashSet<>();
            dfs(curDigits, tempList, new HashSet<>(), 0, 0);
            for (long x1 : tempList) {
                if (x1 >= a && x1 <= b && x1 != i) {
                    count++;
                    hasCaclute.add(x1);
                }
            }
        }
        return count * 1.0f / sum;
    }

    private static void dfs(Set<Long> curDigits, Set<Long> tempList, Set<Long> hasVisited, long value, int size) {
        if (curDigits.size() == size) {
            tempList.add(value);
            return;
        }
        for (long c : curDigits) {
            if (hasVisited.contains(c)) {
                continue;
            }
            hasVisited.add(c);
            value = value * 10 + c;
            dfs(curDigits, tempList, hasVisited, value, size + 1);
            value = value / 10;
            hasVisited.remove(c);
        }
    }

    public static Set<Long> digits(long num) {
        Set<Long> res = new HashSet<>();
        while (num > 0) {
            res.add(num % 10);
            num = num / 10;
        }
        return res;
    }
}
