package NiuKe;

public class T8_3_BitExchange {

    public int[] getSwap(int[] num) {
        // write code here
        if(num == null || num.length != 2){
            return null;
        }

        num[0] = num[0] ^ num[1];
        num[1] = num[0] ^ num[1];
        num[0] = num[0] ^ num[1];
        return num;
    }

}
