package NiuKe;

public class T9_4_StandAlone {

    public int getWays(int n, int A, int b, int c) {
        // write code here
        if(n < 3){
            return 0;
        }

        int num1 = 2*(n-3)*pailie(n-2,n-2);
        int num2 = (n-2)*pailie(n-3,2)*pailie(n-3,n-3);
        return num1+num2;
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
