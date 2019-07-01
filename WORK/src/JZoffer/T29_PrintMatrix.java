package JZoffer;

//顺时针打印矩阵  :    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字.
//例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
//思路：  一圈一圈的打印， 用左上角、右下角两个坐标来进行判断，打印完一圈后缩小范围重复调用
import java.util.ArrayList;

public class T29_PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix){

        if(matrix == null || matrix.length<1){
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();

        //初始化，从最左上到最右下 start end
        int srow = 0;
        int scol = 0;
        int erow = matrix.length-1;
        int ecol = matrix[0].length-1;

        //没有重合前就一直缩小范围
        while(srow <= erow && scol <= ecol){
            printCircle(srow++,scol++,erow--,ecol--,matrix,result);
        }

        return result;
    }

    public static void printCircle(int srow, int scol, int erow, int ecol, int[][] matrix, ArrayList<Integer> result){

        //只打印一行
        if(srow == erow){
            while(scol <= ecol){
                result.add(matrix[srow][scol]);
                scol++;
            }
            return;
        }

        //只打印一列
        if(scol == ecol){
            while(srow <= erow){
                result.add(matrix[srow][scol]);
                srow++;
            }
            return;
        }

        //打印一圈  注意拐点，拐点都要留在下一环节  顺时针：左下右上的顺序
        int temprow = srow;
        int tempcol = scol;

        // ！= 一直到等于时退出，没有处理 =
        while(tempcol != ecol){
            result.add(matrix[temprow][tempcol++]);
        }
        //拐点 matrix[srow][ecol] 留到下面
        while(temprow != erow){
            result.add(matrix[temprow++][ecol]);
        }

        while(tempcol != scol){
            result.add(matrix[temprow][tempcol--]);
        }

        while(temprow != srow){
            result.add(matrix[temprow--][tempcol]);
        }

    }

}
