package LC2023;

public class LC274 {

    public int hIndex(int[] citations) {
        int size = citations.length;
        int max = -1;
        for (int v : citations) {
            max = Math.max(v, max);
        }
        int[] help = new int[max + 1];
        // 数组下标表示被引用的论文次数
        for (int i = 0; i < size; i++) {
            int hvalue = citations[i];
            help[hvalue] += 1;
        }
        int[] prefix = new int[max + 1];
        for (int i = help.length - 1; i >= 0; i--) {
            if (i == help.length - 1) {
                prefix[i] = help[i];
            } else {
                prefix[i] = help[i] + prefix[i+1];
            }
        }
        for (int i = prefix.length - 1; i >= 0; i--) {
            if (prefix[i] >= i)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3,0,6,1,5};
        new LC274().hIndex(citations);
    }
}
