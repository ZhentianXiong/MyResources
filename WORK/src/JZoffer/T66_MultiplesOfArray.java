package JZoffer;

//构建乘积数组：    给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
//暴力法：  O（N^2）
//可以把缺失的一项当作 1 ，这样可以看成一个二维数组，分为上下两个三角形，三角形可分别用循环求解   O(N)
public class T66_MultiplesOfArray {

    public static int[] multiple(int[] array){
        if(array == null || array.length == 0){
            return null;
        }

        int[] result = new int[array.length];
        int[] c = new int[array.length];
        int[] d = new int[array.length];

        c[0] = 1;
        d[array.length-1] = 1;

        for(int i=1;i<array.length;i++){
            c[i] = array[i-1] * c[i-1];
        }

        for(int i = array.length-2;i>=0;i--){
            d[i] = array[i+1] * d[i+1];
        }

        for(int i=0;i<array.length;i++){
            result[i] = c[i] * d[i];
        }
        return result;
    }



}
