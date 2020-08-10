package algorim;

public class SolutionDemo1 {

    // 给定一个正整数
    // 生成长度为N的数组， 使得任意的i,j,k, i<k<j ,有arr[i]+arr[j] != 2*arr[k]
    public static int[] makeno(int size){
        if (size == 1)
            return new int[]{1};

        // size = 7 , basesize = 4;
        int basesize = (size+1)>>1;
        int[] base = makeno(basesize);
        int[] res = new int[size];
        int i = 0;
        for (; i < basesize ; i++) {
            res[i] = base[i]*2-1;
        }
        // 构造剩余部分
        for (;i<size;i++){
            res[i] = base[i-basesize]*2;
        }
        return res;
    }

    private static boolean isValid(int[] arr){
        for (int i = 0; i < arr.length-2; i++) {
            for (int k = i+1; k < arr.length-1 ; k++) {
                for (int j = k+1; j < arr.length; j++) {
                    if (arr[i]+arr[j] == 2*arr[k])
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            int[] arr = makeno(i);
            if (!isValid(arr)){
                System.out.println("false");
            }
        }
        System.out.println("end");
    }
}
