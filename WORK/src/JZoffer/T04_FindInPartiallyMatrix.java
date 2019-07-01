package JZoffer;

/*在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/
//有序二维数组：左上角两边都比他大，不好选择；右下角也是；右上角和左下角一大一小,方便查找
//目标值与数组值相等，直接返回，小于则删除最后一列，大于则删除最上一行；
//二维数组：在内存中从上到下存储各行元素     下标（索引）
public class T04_FindInPartiallyMatrix {
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
                };
        System.out.println(find(5,matrix));

    }

    public static boolean find(int target, int[][] array)
    {
        //输入条件健壮性测试，判断输入是否合法
        if(array == null || array.length<1 || array[0].length<1)return false;
        else return find2(target,0,array[0].length-1,array);
    }

    public static boolean find2(int target, int i, int j, int[][] array)
    {
        //行：row  列：col
        if(i>=array.length || j<0)return false;
        else if(target == array[i][j])return true;
        else if(target > array[i][j]) {i++;return find2(target,i,j,array);}
        else {j--;return find2(target,i,j,array);}
    }

}
