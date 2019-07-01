package JZoffer;

//运算 (n - 1) & n，直至 n 为 0。运算的次数即为 n 的二进制中 1 的个数。
//因为 n-1 会将 n 的最右边一位 1 改为 0，如果右边还有 0，则所有 0 都会变成 1。结果与 n 进行与运算，会去除掉最右边的一个1。

//举个栗子：
//若 n = 1100，
//n - 1 = 1011
//n & (n - 1) = 1000
//即：把最右边的 1 变成了 0。

//把一个整数减去 1 之后再和原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最右边的 1 变成 0。很多二进制的问题都可以用这种思路解决。
//判断一个整数是不是2的整数次方，即判断其二进制中是不是有且仅有一位是1
public class T15_BinaryNumberCount_2 {
    public static int NumberOf1(int n)
    {
        int sum=0;
        while(n != 0)
        {
            n = n&(n-1);
            sum++;
        }
        return sum;
    }


    public static void main(String[] args)
    {
        System.out.println(NumberOf1(10));
    }
}
