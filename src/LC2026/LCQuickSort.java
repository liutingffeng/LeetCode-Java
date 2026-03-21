package LC2026;

public class LCQuickSort {


    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int target = arr[l];

        int small = l;
        int big = r;
        int i = l + 1;

        while (i <= big) {
            // 小于
            if (arr[i] < target) {
                swap(arr, small, i);
                small++;
                i++;
            } else if (arr[i] > target) {
                // 大于
                swap(arr, i, big);
                big--;
            } else {
                //相等
                i++;
            }
        }
        // 递归
        // 2 1 3   1 2 3
        // [l, small)  [small, big], (big, r]
        sort(arr, l, small - 1);
        sort(arr, big + 1, r);
    }

    private static void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    public static void main(String[] args) {
        // 测试1：大量重复元素（三路快排的优势场景）
        int[] arr1 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0, 2, 8, 8, 4, 1, 9, 7, 1, 6, 9, 3, 9, 9, 3, 7, 5, 1};
        System.out.println("测试1：大量重复元素");
        testSort(arr1);

        // 测试2：普通数组
        int[] arr2 = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        System.out.println("\n测试2：普通数组");
        testSort(arr2);

        // 测试3：全部相同
        int[] arr3 = {5, 5, 5, 5, 5, 5, 5};
        System.out.println("\n测试3：全部相同元素");
        testSort(arr3);

        // 测试4：两个元素交替
        int[] arr4 = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        System.out.println("\n测试4：两个元素交替");
        testSort(arr4);
    }

    private static void testSort(int[] arr) {
        System.out.println("原始: " + arrayToString(arr));
        quickSort(arr);
        System.out.println("排序: " + arrayToString(arr));
        System.out.println("验证: " + (isSorted(arr) ? "✓ 有序" : "✗ 错误"));
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    private static String arrayToString(int[] arr) {
        if (arr.length > 20) {
            return "[" + arr[0] + ", " + arr[1] + ", ... , " + arr[arr.length-2] + ", " + arr[arr.length-1] + "] (长度:" + arr.length + ")";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
