package sync;

public class BankTest {
    private static int[] Avaliable = {3, 3, 2};
    private static int[][] Allocation = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
    private static int[][] Need = {{7, 4, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
    private static int[] processId = new int[5];

    public static boolean securityCheck(){
        int[] work = Avaliable;
        boolean[] fininshed = new boolean[Allocation.length];
        int n = Allocation.length;  //进程数量
        int m = Avaliable.length;  //资源数量

        int j,p=0;
        boolean flag;
        for (int i=0;i<n;i++){
            flag = false;
            for (int id=0;id<n;id++){

                if (fininshed[id] == true)
                    continue;

                for ( j=0;j<m;j++){
                    if (Need[id][j]>Avaliable[j])
                        break;
                }

                if (j == m){
                    for (j=0;j<m;j++)
                        Avaliable[j] +=Allocation[id][j];
                    fininshed[id] = true;
                    flag = true;
                    processId[p++] = id;
                    System.out.println("进程："+id);
                    break;
                }
            }

            if (!flag){
                break;
            }
        }

        for (boolean b:fininshed)
            if (!b)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(securityCheck());
    }

}
