package JZoffer;

//旋转数组的最小数字：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
//例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
//有一定的顺序，二分查找 O（log N）
public class T11_MinNumberInRotatedArray2 {

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.print(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int[] array)
    {
        if(array == null)return 0;
        return binarySearch(array,0,array.length-1);
    }

    //二分递归调用，当两者索引相差1时，second位置就是要返回的值
    //当low=middle=second时，无法确定在那一边，必须要顺序遍历，  10111   11101
    //first永远指向第一个数组，second永远指向第二个数组
    public static int binarySearch(int[] array,int first,int second)
    {
        if(second-first == 1)return array[second];
        int middle = first+(second-first)/2;
        if(array[middle]==array[first] && array[middle]==array[second])return shunxu(array,first,second);
        if(array[middle]>=array[first]) return binarySearch(array,middle,second);
        else if(array[middle]<=array[second])return binarySearch(array,first,middle);
        else return -1;
    }

    //顺序扫描，注意防止数组越界
    public static int shunxu(int [] array,int first,int second) {
        for(int i=first;i<=second-1;i++)
        {
            if(array[i]>array[i+1])return array[i+1];
        }
        return -1;
    }


}
