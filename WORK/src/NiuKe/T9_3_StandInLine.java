package NiuKe;

public class T9_3_StandInLine{

    public int[] getWays(int n, int a, int b) {
        // write code here
        if(n<2){
            return new int[0];
        }

        int[] res = new int[2];
        res[0] = pailie(n,n)/2;
        res[1] = pailie(n-1,n-1);
        return res;
    }

    public static int pailie(int n,int x){
        int res = 1;
        while(x != 0){
            res *= n--;
            x--;
        }
        return res;
    }

    public static int zuhe(int n,int x){
        int fenzi = 1;
        int fenmu = 1;
        while(x != 0){
            fenzi *= n--;
            fenmu *= x--;
        }
        return fenzi/fenmu;
    }

}
