package JZoffer;

//斐波那契数列（递归/循环），现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0,第1项为1，后面的每项为前面两项之和）。
public class T10_fibonacci {

    //不推荐
    //递归解法，大量重复运算，f(8),f(7)都需要计算f(6)。。。呈 N 的指数倍增长
    public static int Fibonacci(int n)
    {
        if(n<0) return 0;
        if(n<2) return n;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args)
    {
        System.out.println(Fibonacci(2));
        System.out.println(Fibonacci2(39));
    }

    //推荐
    //循环解法，从下往上计算，先计算小的   时间复杂度： O（N）
    public static int Fibonacci2(int n)
    {
        if(n<0) return 0;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        if(n<2) return f[n];
        for(int i =2;i<=n;i++)
        {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }


}
