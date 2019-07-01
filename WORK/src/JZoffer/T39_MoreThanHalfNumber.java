package JZoffer;

//数组中出现次数超过一半的数字：   数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
//解法1：基于Partition函数的时间复杂度为 O（n） 的算法   出现次数超过一半则中位数的位置一定为该数，利用快速排序递归可以找到该数字
//partition 可以在 O（n）时间内找到任意第 k 大的数字
public class T39_MoreThanHalfNumber {

    public static int moreThanHalfNumber(int[] array) {

        if(array == null || array.length == 0){
            return 0;
        }

        int mid = array.length/2;
        int start = 0;
        int end = array.length-1;
        int index = Partition(array,start,end);
        //一直递归到中位数
        while(index != mid){
            if(index > mid) index = Partition(array,start,index-1);
            else index =  Partition(array,index+1,end);
        }

        //中位数出现频率是否超过一半
        if(moreThanHalf(array,array[index]) == true)return array[index];
        else return 0;
    }

    //快速排序 一轮 返回基准值的坐标
    public static int Partition(int[] array, int start, int end){
        if(start > end){
            return 0;
        }

        int temp = array[start];
        int i = start;
        int j = end;

        while(i < j){
            while(i<j && array[j] >= temp){
                j--;
            }
            array[i] = array[j];

            while(i<j && array[i] <= temp){
                i++;
            }
            array[j] = array[i];
        }
        array[j] = temp;
        return j;
    }

    //好的partition算法，可以避免比较重复的基准值
    public static int[] partition1(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }


    public static boolean moreThanHalf(int[] array, int val){
        int num = 0;
        for(int i = 0; i< array.length;i++){
            if(array[i] == val){
                num++;
            }
        }
        if(num > array.length/2)return true;
        else return false;
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = array[i];
    }


    public static void main(String[] args){
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNumber(array));
    }

}
