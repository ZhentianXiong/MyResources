package JZoffer;

//快速排序：先取一个数作为基数，然后记录下输入的索引上下界指针，然后从high开始判断逐渐往前，碰到小的就替换到low，然后操作low指针，一直到low=high，替换temp值，然后递归
//原地切分  且比较次数少  平衡性很好 如果每次都能对半切分，则最好时间效率 O（NlgN） 每轮都要遍历所有数组N，对半切分共有lgN轮
//改进方法：
// 1。当递归到小数组时，将快速排序切换到插入排序更快
// 2。三取样切分：使用子数组中的3位元素的中位数来切分数组
// 3。如果数组中含有大量重复元素：且可以将数组分成小于、等于、大于三部分子数组，此时可从NlgN降低到N
public class T00_QuickSort {

    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(array,0,array.length-1);
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }

    public static void quickSort(int[] array,int low,int high)
    {
        if(low>high)return;
        //low位置可用来存储小于基数的数了，所以之后从后往前遍历
        int temp = array[low];
        int templow = low;
        int temphigh = high;
        //一直遍历到high=low
        while(high>low)
        {
            //不大于，不小于，都带上等号
            while (array[high] >= temp && high>low) high--;
            array[low] = array[high];
            //low++；删掉这句，只是转移到操作low指针
            //更改指针后，不用急着变换，while语句会自增自减
            while(array[low]<=temp && high>low)low++;
            array[high] = array[low];
        }
        //之后low=high
        array[high] = temp;
        //注意边界条件，防止数组越界
        //左边还有子数组，才排左边
        if(low>templow) quickSort(array,templow,low-1);
        if(high<temphigh)quickSort(array,high+1,temphigh);
    }


}
