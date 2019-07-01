package NiuKe;

public class T9_2_MoveMatrix {

    public int countWays(int x, int y) {
        // write code here
        if(x < 2 && y < 2){
            return 0;
        }

        int totalStep = x + y -2;
        return pailiezuhe(totalStep,x-1);
    }

    public int pailiezuhe(int n,int x){
        int fenmu = 1;
        int fenzi = 1;
        while(x != 0){
            fenmu = fenmu * (n--);
            fenzi = fenzi * (x--);
        }
        return fenmu/fenzi;
    }

}
