package NiuKe;

public class T8_5_BitJishu {

    public int findOdd(int[] A, int n) {
        // write code here
        if(A == null || A.length == 0){
            return Integer.MAX_VALUE;
        }

        int res = 0;
        for(int e : A){
            res ^= e;
        }
        return res;
    }

}
