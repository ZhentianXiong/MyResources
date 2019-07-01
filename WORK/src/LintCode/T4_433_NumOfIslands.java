package LintCode;

//岛屿的数量
public class T4_433_NumOfIslands {

    public int numIslands(boolean[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int island = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]){
                    island++;
                    bfs(grid,i,j);
                }
            }
        }

        return island;
    }

    //BFS 广度优先搜索 或 拓扑结构
    public static void bfs(boolean[][] grid,int i,int j){
        if(i<0 || i>grid.length || j<0 || j>grid[0].length){
            return;
        }

        if(grid[i][j]){
            grid[i][j] = false;
            bfs(grid,i-1,j);
            bfs(grid,i+1,j);
            bfs(grid,i,j-1);
            bfs(grid,i,j+1);
        }
    }

}
