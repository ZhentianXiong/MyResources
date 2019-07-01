package LintCode;

public class T8_115_UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid == null || m == 0 || n == 0){
            return 0;
        }

        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1){
            dp[0][0] = 0;
        }else{
            dp[0][0] = 1;
        }

        for(int i = 1;i<n;i++){
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
            }else{
                dp[0][i] = Math.min(dp[0][i-1],1);
            }
        }

        for(int i = 1;i<m;i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            }else{
                dp[i][0] = Math.min(dp[i-1][0],1);
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
