package JZoffer;

//？？？？
//打印从 1 到最大的 n 位数：输入3则打印从1到最大的三位数 999
public class T17_Print1ToNNN {

    public static void print1ToMaxOfNDigits(int n)
    {
        if(n<=0){
            throw new RuntimeException("input unvalid!");
        }

        int[] a = new int[n];
        OneToNDigits(0,a);
    }

    // n 表示处理第几位，把每一位数字都从0-9全部排列一遍即可
    public static void OneToNDigits(int n, int[] a){
        //所有的数据排列选择已经处理完了
        //当最高位需要进1时表示结束
        if(n>=a.length){
            //处理完了才开始 递归 输出
            printnum(a);
        } else{
            //先处理a[100,200...,101,102,...]即先处理 n 再处理 i
            //先从第0位取0-9 再从第1位取0-9，直到所有位，从而完成全排列
            for(int i=0; i<=9;i++){
                a[n] = i;
                OneToNDigits(n+1,a);
            }
        }
    }

    //输出：除去前面的非零位
    public static void printnum(int[] array)
    {
        int j=array.length-1;
        while(array[j]==0 && j>0) {
            j--;
        }
        for(int i=j;i>=0;i--)
        {
            System.out.print(array[i]);
        }
        System.out.print(" ");
    }

    public static void main(String[] args){
        print1ToMaxOfNDigits(3);
    }


}
