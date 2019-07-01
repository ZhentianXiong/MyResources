package JZoffer;

//矩阵中的路径
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
// 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
// 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
// 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
public class T12_PathMatrix {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || str==null || matrix.length!=rows*cols || str.length>matrix.length) return false;
        boolean[] visited = new boolean[matrix.length];
        int pathlength =0;
        //从矩阵的每一个数开始往下暴力回溯
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(huisu(matrix,rows,cols,str,i,j,pathlength,visited))return true;
            }
        }
        return false;
    }

    //huisu(原始矩阵，行数，列数，匹配字符数组，行数变量i,列数变量j，将要匹配str中的第几个数，是否访问过不能重复)
    public static boolean huisu(char[] matrix,int rows,int cols,char[] str,int i,int j,int pathlength,boolean[] visited)
    {
        if(pathlength == str.length) return true;
        boolean haspath=false;
        //满足以下条件才能继续回溯，否则支路不可行
        if(i>=0 && i<rows && j>=0 && j<cols && matrix[i*cols+j]==str[pathlength] && visited[i*cols+j]==false) {
            pathlength++;
            visited[i * cols + j] = true;
            haspath = huisu(matrix, rows, cols, str, i + 1, j, pathlength, visited)
                    || huisu(matrix, rows, cols, str, i - 1, j, pathlength, visited)
                    || huisu(matrix, rows, cols, str, i, j + 1, pathlength, visited)
                    || huisu(matrix, rows, cols, str, i, j - 1, pathlength, visited);
            //匹配失败，需要往回重置信息
            if (haspath == false) {
                pathlength--;
                visited[i * cols + j] = false;
            }
        }
        return haspath;

    }



    public static void main(String[] args)
    {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'b','c','c','e','d'};
        System.out.println(hasPath(matrix,3,4,str));
    }

}