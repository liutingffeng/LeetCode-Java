package algorim.sorting;

import java.util.Random;

public class QuickSort2Ways {

    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    // 对[left,right] 使用双路快排
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

        int randIndex = new Random().nextInt(right+1-left)+left;
        swap(arr, left, randIndex);
        int e = arr[left];

        int l = left+1; // [1,l) <= e
        int r = right; // (r,n-1) > e
        while (l<=r){
            if (arr[l]<=e){
                l++;
            }
            else {
                swap(arr, l, r--);
            }
        }

        // 把e 放入正确的位置
        swap(arr, left, l-1);

        sort(arr, left, l-2);
        sort(arr, l, right);
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("algorim.sorting.QuickSort2Ways", arr);
        SortTestHelper.printArray(arr);

    }
}
