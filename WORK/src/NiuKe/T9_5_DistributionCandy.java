package NiuKe;

public class T9_5_DistributionCandy {

    public int getWays(int n, int m) {
        // write code here
        return zuhe(n-1,m-1);
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
