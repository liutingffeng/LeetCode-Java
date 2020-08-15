package algorim.sorting;

public class InsertionSort {

    public static void sort(int[] arr){

        // [0,i) 是有序的
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            // 将arr[i] 插入到合适的位置
            int j = i;
            // 1 , 2, 4, 5  , 3
            for (; j-1 >=0 && e < arr[j-1]; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("algorim.sorting.InsertionSort", arr);
        SortTestHelper.testSort("algorim.sorting.ShellSort", arr);
    }
}
