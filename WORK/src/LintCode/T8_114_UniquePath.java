package LintCode;

public class T8_114_UniquePath {

    //动态规划： 机器人从左上到右下的不同路径
    //自上而下分析，自下而上解决
    //状态+转移+初始化：    状态：求出（m-1，n-1）位置的路径数，  转移 = 自上+自左的路径和  初始化：最上行和最左列均为1
    public int uniquePaths(int m, int n) {
        // write your code here
        if(m <= 0 || n <= 0){
            return 0;
        }

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
