package algorim.sorting;

public class SelectionSort2 {

    // 在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
    public static void sort(int[] arr){
        int n = arr.length;

        int left = 0;
        int right = n-1;

        while (left<right){

            int minIndex = left;
            int maxIndex = right;

            for (int i = left; i <= right; i++) {
                if (arr[i]<arr[minIndex])
                    minIndex = i;
                if (arr[i]>arr[maxIndex])
                    maxIndex = i;
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
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
//        SortTestHelper.testSort("algorim.sorting.SelectionSort", arr);
        SortTestHelper.testSort("algorim.sorting.SelectionSort2", arr);
        SortTestHelper.printArray(arr);
    }
}
