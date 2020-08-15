package algorim.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort3Ways {

    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    // 对[left,right] 使用三路快排
    private static void sort(int[] arr,int left,int right){
        // 对于小规模数组, 使用插入排序
        /*
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }
         */

        if (left >= right)
            return;
        // 随机化

        swap(arr, left, new Random().nextInt(right+1-left)+left);
        int e = arr[left];

        int lt = left+1; // [l+1,lt) < e
        int gt = right; // (gt,r] > e
        int i = left+1;  // [lt,i) == e
        while (i<=gt){
            if (arr[i] == e){
                i++;
            }
            else if (arr[i] < e){
                swap(arr, lt++, i++);
            }
            else {
                swap(arr, i, gt--);
            }
        }

        // 把e 放入正确的位置
        swap(arr, left, lt-1);

        sort(arr, left, lt-2);
        sort(arr, gt+1, right);
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 1000000;
        int[] arr = SortTestHelper.generateRandomArray(N,0,N);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("algorim.sorting.QuickSort2Ways", arr);
        SortTestHelper.testSort("algorim.sorting.QuickSort3Ways", arr);
//        SortTestHelper.printArray(arr);

    }
}
