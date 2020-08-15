package algorim.sorting;


public class BubbleSort {

    public static void sort(int[] arr){

        boolean bubbled = true;
        for (int i = arr.length-1; i > 0 ; i--) {
            if (!bubbled){
                break;
            }
            bubbled = false;
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                    bubbled = true;
                }
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int N = 20000;
//        int[] arr = SortTestHelper.generateRandomArray(N,0,100000);
//        SortTestHelper.testSort("algorim.sorting.BubbleSort", arr);

        sort(new int[]{1,2,3});
    }
}
