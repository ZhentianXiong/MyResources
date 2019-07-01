package JZoffer;

import java.util.ArrayList;

//圆圈中最后剩下的数字（约瑟夫环问题）：     N个数（0-N-1）排成一个圆圈，从0开始每次删除第 M 个数，求出最后剩余的那一个数
//可以用 链表/动态数组 进行求解     时间复杂度：O(mn),  空间复杂度： O（n）
//用公式求解    f(n,m) = 0 (n=1)   = [f(n-1,m)+m]%n (n>1)  时间复杂度：O(n),  空间复杂度： O（1）
public class T62_LeftNumber_Josephuse {

    public static int leftNumber(int n, int m){
        if(n < 1 || m < 1){
            return -1;
        }

        ArrayList<Integer> stu = new ArrayList<>();
        for(int i = 0; i < n; i++){
            stu.add(i);
        }

        int index = 0;
        while(stu.size() != 1){
            //数学归纳法  求余即形成 环 的操作
            index = (index + m -1)%stu.size();
            stu.remove(index);
        }
        return stu.get(0);
    }

    //解法2
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }

        int last = 0;
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }


}
