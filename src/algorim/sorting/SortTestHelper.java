package algorim.sorting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SortTestHelper {

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random()*(rangeR-rangeL+1)+rangeL);
        }
        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    // 判断arr数组是否有序
    public static boolean isSorted(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]<arr[i-1])
                return false;
        }
        return true;
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, int[] arr) {
        try {
            Class<?> sortClass = Class.forName(sortClassName);
            // 获取排序函数
            Method sort = sortClass.getDeclaredMethod("sort", int[].class);


            long startTime = System.currentTimeMillis();
            // 调用函数
            sort.invoke(null, arr);
            long endTime = System.currentTimeMillis();

            if (!isSorted(arr))
                System.out.println(false);

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }
}
