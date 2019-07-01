package JZoffer;

//二分查找的递归实现：对于已经排好序的数组每次去中间值进行比较后递归返回数组坐标
public class T00_BinarySearch {

    //递归实现
    public static int binarySearch(int[] array,int low,int high,int target)
    {
        if(array.length<1)return -1;
        if(low>high)return -1;
        int middle = (low+high)/2;
        if(target == array[middle])return middle;
        else if(target > array[middle]) return binarySearch(array,middle+1,high,target);
        else return binarySearch(array,low,middle-1,target);
    }

    //循环实现
    public static int binarySearch2(int key,int low,int high, int[] array)
    {
        //low超过high即停止
        while(low<=high)
        {
            int middle = (high+low)/2;
            if(key < array[middle]) high = middle-1;
            else if(key > array[middle]) low = middle+1;
            else return middle;
        }
        return -1;
    }

    /*
    //适用于有两段时的二分查找，如先上升在下降的，可以找到极值附近的两个值
    //start和end相邻就终止
      while(start + 1 < end){
        int mid = start + (end - start) / 2;
        if(A[mid] >= target){
            end = mid;
        }else{
            start = mid;
        }
      }
      */

    public static void main(String[] args)
    {
        int[] array = {1,2,4,5,6,7,8,9};
        System.out.println(binarySearch(array,0,array.length-1,3));
        System.out.println(binarySearch(array,0,array.length-1,4));
    }


}
