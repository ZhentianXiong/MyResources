package algorithms4;

//九皇后问题
public class liu3 {

    static int count = 0;
    static int [][] chess = new int [9][9];
    public static void main(String[] args) {
        settleQueen(0);
        System.out.println("共有"+count+"种解法");

    }
    public static void settleQueen(int n){
        if(n==9){
            count++;
            System.out.println("第"+count+"种方法");
            printBoard(chess);
        }else{
            for(int i=0;i<9;i++){
                //把该行清零，防止有残余的皇后（1）
                for(int j=0;j<9;j++){
                    chess[n][j]=0;
                }

                if(checkBoard(chess,n,i)){
                    chess[n][i]=1;
                    settleQueen(n+1);
                }
            }
        }
    }
    public static boolean checkBoard(int [][] arr, int x,int y){
        //判断列
        for(int i=x;i>=0;i--){
            if(arr[i][y]==1){
                return false;
            }
        }
        //判断左上到右下对角线
        for(int i=x,j=y;i>=0 && j>=0;i--,j--){
            if(arr[i][j]==1){
                return false;
            }
        }
        //判断右上到左下对角线
        for(int i=x,j=y;i>=0 && j<arr.length;i--,j++){
            if(arr[i][j]==1){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void initBoard(int [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=0;
            }
        }
    }


}
