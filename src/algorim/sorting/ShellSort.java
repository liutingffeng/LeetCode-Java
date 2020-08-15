package algorim.sorting;

import java.util.Arrays;

public class ShellSort {

//    public static void sort(int[] arr){
//        int len = arr.length;
//        // 步长
//        int step = len /2 ;
//
//        while (step >= 1){
//            // 对么一部分进行插入排序
//            for (int i = step; i < len ; i++) {
//                // arr[i],arr[i-step],arr[i-2*step]
//                int j = i;
//                int e = arr[j];
//                for (; j-step>=0 && e<arr[j-step] ; j-=step) {
//                    arr[j] = arr[j-step];
//                }
//                arr[j] = e;
//            }
//            step /=2;
//        }
//    }


    public static void sort(int[] arr){
        int len = arr.length;
        // 将步长进行改进
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int step = 1;
        while (step < len/3)
            step = step*3 + 1;

        while (step >=1 ){

            for (int i = step; i < len; i++) {
                int j = i;
                int e = arr[i];
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                for ( ; j-step >=0 && arr[j-step]>e ; j -= step) {
                    arr[j-step] = arr[j];
                }
                arr[j] = e;
            }

            step /= 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
        sort(arr);
        Arrays.stream(arr).boxed().forEach(System.out::print);
        System.out.println(arr);
    }
}
