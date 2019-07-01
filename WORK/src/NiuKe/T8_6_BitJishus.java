package NiuKe;

public class T8_6_BitJishus {

    public int[] findOdds(int[] arr, int n) {
        // write code here
        if(arr == null || arr.length < 2){
            return null;
        }

        int res1 = 0,res2 = 0;
        int temp = 0;
        for(int e : arr){
            temp ^= e;
        }

        //找出最右边不为0的那一位
        int rightone = temp & (~temp + 1);

        for(int e : arr){
            if((e & rightone) != 0){
                res1 ^= e;
            }
        }

        res2 = temp ^ res1;
        return new int[]{Math.min(res1,res2),Math.max(res1,res2)};

    }

}
