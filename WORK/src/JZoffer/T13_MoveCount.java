package JZoffer;

//机器人的运动范围
//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
//例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
//回溯：得将递归结果合并起来，比如与或非或者是想加起来才是回溯
public class T13_MoveCount {

    public static void main(String[] args)
    {
        System.out.println(movingCount(18,35,37));
    }


    public static int movingCount(int threashold,int rows,int cols)
    {
        //不符合输入，直接返回0
        if(threashold<0 || rows<1 || cols<1)return 0;
        //复制一个相同大小的boolean数组，避免重复计数
        boolean[] visited = new boolean[rows*cols];
        //i，j表示正在处理第i行第j列个数，而且方便递归
        return huisu(threashold,rows,cols,0,0,visited);
    }

    public static int huisu(int threashold,int rows,int cols,int i,int j,boolean[] visited)
    {
        //数组越界或已经计数过直接退出
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i*cols+j]==true)return 0;
        if(compare(threashold,i,j))
        {
            visited[i*cols+j]=true;
            //总数 = 第一个数（一定满足） + 前后左右四个方向之和
            return 1+ huisu(threashold,rows,cols,i-1,j,visited)
                    + huisu(threashold,rows,cols,i+1,j,visited)
                    + huisu(threashold,rows,cols,i,j-1,visited)
                    + huisu(threashold,rows,cols,i,j+1,visited);
        }
        return 0;
    }

    //位数之和与阈值做比较
    public static boolean compare(int threashold,int i,int j)
    {
        int sum = digitalsum(i)+digitalsum(j);
        if(sum<=threashold)return true;
        else return false;
    }

    public static int digitalsum(int i)
    {
        int sum = 0;
        while(i>0)
        {
            sum+=i%10;
            i/=10;
        }
        return sum;
    }

}
