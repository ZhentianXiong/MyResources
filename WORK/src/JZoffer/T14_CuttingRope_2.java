package JZoffer;

//贪心算法求解：O（1）时间，O（1）空间
//贪心策略：长度大于等于5时，尽可能多的剪3 长度等于4时剪2*2  因为：n>=5时， 3(n-3) >= 2(n-2)
public class T14_CuttingRope_2 {

    public static int cutRope(int n) {
        //数学归纳法：特殊情况直接返回
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int three = 0;
        int two = 0;
        while(n>=4)
        {
            if(n==4)
            {
                two+=2;
                n-=4;
            }else
            {
                n-=3;
                three++;
            }
        }
        if(n>0)return (int)(n*Math.pow(3,three)*Math.pow(2,two));
        else return (int)(Math.pow(3,three)*Math.pow(2,two));
    }

    public static void main(String[] args)
    {
        int n=34;
        System.out.println(cutRope(n));
    }

}
