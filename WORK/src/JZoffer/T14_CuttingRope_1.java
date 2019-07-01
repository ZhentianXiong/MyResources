package JZoffer;

//动态规划求解：O（N^2）时间    O(N)空间 以空间换时间
//剪绳子：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1]…*k[m]可能的最大乘积是多少？
// 例如当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到最大的乘积18。
public class T14_CuttingRope_1 {

    public static int cutRope(int n)
    {
        //数学归纳法：特殊情况直接返回
        if(n<=1)return 0;
        if(n==2) return 1;
        if(n==3) return 2;

        //创建一个大一点的数组，以空间来换取时间
        int[] maxMul = new int[n+1];
        //此时 N》=4，如5=2+3，但是f(3)<3 所以3可以不用再划分，取3是会有最大值
        //maxMul[0]=0;
        maxMul[1]=1;
        maxMul[2]=2;
        maxMul[3]=3;

        //自下而上实现求出每一个长度时的最大积
        for(int i=4;i<=n;i++)
        {
            int max=0;
            //划分到 N/2 即可
            for(int j=1;j<=i/2;j++)
            {
                if(maxMul[j]*maxMul[i-j]>max)max=maxMul[j]*maxMul[i-j];
            }
            maxMul[i]=max;
        }

        return maxMul[n];
    }

    public static void main(String[] args)
    {
        int n=34;
        System.out.println(cutRope(n));
    }


}
