package algorithms4;

//二分查找
//先获取数组，对数组进行排序，然后每次对中间值进行排序，缩小比较范围（用索引来进行操作）
import java.util.Scanner;
import java.util.Arrays;

import static java.lang.System.in;

public class BinarySearch {

    public static void main(String[] args)
    {
        //导包快捷键：option+enter
        Scanner input = new Scanner(in);
        String array1 = input.nextLine();
        String[] array2 = array1.split(" ");
        int len = array2.length;
        int[] array = new int[len];
        for(int i = 0;i<len;i++)
        {
            array[i] = Integer.parseInt(array2[i]);
        }
        Arrays.sort(array);
        for(int i = 0;i<len;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        int key = input.nextInt();
        System.out.println(binarySearch(key,0,len-1,array));
    }

    public static int binarySearch(int key,int low,int high, int[] array)
    {
        while(low<=high)
        {
            int middle = (high+low)/2;
            if(key < array[middle]) high = middle-1;
            else if(key > array[middle]) low = middle+1;
            else return middle;
        }
        return -1;
    }

}
