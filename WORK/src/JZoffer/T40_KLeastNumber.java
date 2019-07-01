package JZoffer;

//时间复杂度更小 ：O（N）
//最小的 K 个数： 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
//用快速排序中的partition思想，定位到 K-1 的位置，即可找到最小的 K 个数，时间复杂度 O（N），但是需要修改数组
import java.util.ArrayList;

public class T40_KLeastNumber {

    public static ArrayList<Integer> k_LeastNumber(int[] array, int k){
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length == 0 || k <= 0 || k>array.length){
            return result;
        }

        int start = 0;
        int end = array.length-1;
        int index = Partition(array,start,end);
        //如果用 K 做判断容易发生数组越界
        while(index != k-1){
            if(index > k-1)index = Partition(array,start,index-1);
            else index = Partition(array,index+1,end);
        }

        for(int i =0;i<k;i++){
            result.add(array[i]);
        }
        return result;
    }

    public static int Partition(int[] array,int start,int end){
        int temp = array[start];
        while(start < end){

            while(start < end && array[end] >= temp){
                end--;
            }
            array[start] = array[end];

            while(start < end && array[start] <= temp){
                start++;
            }
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }

}
