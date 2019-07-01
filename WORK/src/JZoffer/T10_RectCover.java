package JZoffer;

//矩阵覆盖：我们可以用2*1（两行一列）的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
//数学归纳法
public class T10_RectCover {
    public int RectCover(int n) {
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
}
