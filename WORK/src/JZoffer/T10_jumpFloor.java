package JZoffer;

//跳台阶：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//分析不清楚时记得先举几个例子，此题与斐波那契数列初始化略有不同
public class T10_jumpFloor {

    public static int JumpFloor(int n)
    {
        if(n<0) return 0;
        if(n<3) return n;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for(int i=3;i<n+1;i++)
        {
            //每次可以跳一级或两级，=跳一级后后面的总数 + 跳两级后后面的总数
            f[i] = f[i-1]+f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args)
    {
        System.out.println(JumpFloor(40));
    }


}
