package algorim.sorting;

import java.util.Arrays;

// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort {

    public static void sort(int[] arr){
        int n = arr.length;

        /*
                 0
              1      2
            3   4  5   6
          7
         */

        // 构建最大堆
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n-1-1)/2; i >=0 ; i--) {
            shiftdown(arr,n,i);
        }

        // 堆排序，将最大值放在后面
        for (int i = n-1; i > 0 ; i--) {
            swap(arr, 0, i);
            shiftdown(arr, i, 0);
        }
    }

    //
    private static void shiftdown(int[] arr, int n, int k){

//        int left = (k<<1) + 1;
//        int right = (k<<1) + 2;
//        int maxIndex = k;
//        if (left < n && arr[left] > arr[maxIndex])
//            maxIndex = left;
//        if (right < n && arr[right] > arr[maxIndex])
//            maxIndex = right;
//
//        if (maxIndex != k) {
//            swap(arr, k, maxIndex);
//            shiftdown(arr, n, maxIndex);
//        }

        int e = arr[k];
        while ((k<<1)+1 < n){
            // 左孩子索引
            int j = (k<<1) + 1;
            // 右孩子的值大于左孩子
            if (j+1 < n && arr[j+1]>arr[j])
                j += 1;

            if (e >= arr[j])
                break;

            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    /*
    // 像最大堆中插入一个新的元素 item
    public void insert(Item item){

        assert count + 1 <= capacity;
        data[count+1] = item;
        count ++;
        shiftUp(count);
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k){

        while( k > 1 && data[k/2].compareTo(data[k]) < 0 ){
            swap(k, k/2);
            k /= 2;
        }
    }
     */

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 1000000;
        int[] arr = SortTestHelper.generateRandomArray(N,0,N);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("algorim.sorting.HeapSort", arr);
        SortTestHelper.testSort("algorim.sorting.QuickSort3Ways", arr2);
//        SortTestHelper.printArray(arr);

    }
}
