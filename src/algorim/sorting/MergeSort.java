package algorim.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr,int l, int r){
        if (l >= r)
            return;

        // 优化2: 对于小规模数组, 使用插入排序
//        if (r-l<15){
//            InsertionSort.sort(arr,l,r);
//            return;
//        }

        int mid = l + (r-l)/2;
        sort(arr,l,mid);
        sort(arr, mid+1, r);
        // 对arr[l,mid] [mid+1,r]归并
        if (arr[mid]<=arr[mid+1])
            return;
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l,int mid,int r){
        int[] helper = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i>mid){ // 如果左半部分元素已经全部处理完毕
                arr[k] = helper[j-l];
                j++;
            }
            else if (j>r){  // 如果右半部分元素已经全部处理完毕
                arr[k] = helper[i-l];
                i++;
            }
            else if (helper[i-l]<=helper[j-l]){  // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = helper[i-l];
                i++;
            }
            else {  // 左半部分所指元素 > 右半部分所指元素
                arr[k] = helper[j-l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("algorim.sorting.MergeSort", arr);
        SortTestHelper.printArray(arr);

//        sort(new int[]{1,2,3});
    }
}
