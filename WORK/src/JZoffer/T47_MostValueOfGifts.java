package JZoffer;

//礼物的最大价值：   在一个 m×n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格直到到达棋盘的右下角。
//给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
//动态规划：   递推式：    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]) + grid[i][j];    循环代码实现减少重复计算
public class T47_MostValueOfGifts {

    public static void main(String[] args){
        int[][] a = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(mostValueOfGifts(a));
    }

    public static int mostValueOfGifts(int[][] array){
        if(array == null || array.length == 0){
            return -1;
        }

        //辅助数组存储子结果，即当前的最大值
        int[][] max = new int[array.length][array[0].length];

        //解法2
        max[0][0] = array[0][0];
        for(int j = 1;j<array[0].length;j++){
            max[0][j] = max[0][j-1] + array[0][j];
        }

        for(int i=1;i<array.length;i++){
            max[i][0] = max[i-1][0] + array[i][0];
        }

        for(int i = 1;i<array.length;i++){
            for(int j=1;j<array[0].length;j++){
                max[i][j] = Math.max(max[i-1][j],max[i][j-1]) + array[i][j];
            }
        }


        //注意处理好数组边界值
/*        for(int i = 0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(i == 0){
                    if(j == 0)max[i][j] = array[i][j];
                    else max[i][j] = max[i][j-1] + array[i][j];
                }else{
                    if(j == 0)max[i][j] = max[i-1][j] + array[i][j];
                    else max[i][j] = Math.max(max[i][j-1],max[i-1][j]) + array[i][j];
                }
            }
        }*/



        return max[array.length-1][array[0].length-1];
    }


}
