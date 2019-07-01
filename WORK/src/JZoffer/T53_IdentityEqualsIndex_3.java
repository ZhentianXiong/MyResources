package JZoffer;

//数组中数值和下标相等的元素：    一个单调递增的元素中每个元素都是唯一的，请找出任意一个数值等于其下标的元素
//利用有序的性质： 二分查找   若数值大于坐标，则右半边不用找；若数值小于坐标，则左半边不用找了
public class T53_IdentityEqualsIndex_3 {

    public static void main(String[] args){
        int[] a = {-3,-1,1,3,5};
        System.out.println(findEquals(a));
    }

    public static int findEquals(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int start = 0;
        int end = array.length-1;
        while(start <= end){
            int mid  = start + ((end - start)>>1);
            if(mid == array[mid]){
                return mid;
            }else{
                if(mid < array[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


}
