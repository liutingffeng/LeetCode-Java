package algorim.sorting;

public class SelectionSort {

    public static void sort(int[] arr){

        int n = arr.length;
        // 从 arr[i,n-1] 中选择最小值
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j]<arr[minIndex])
                    minIndex = j;
            }

            swap(arr, i, minIndex);
        }
    }

    

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("algorim.sorting.SelectionSort", arr);
    }
}
