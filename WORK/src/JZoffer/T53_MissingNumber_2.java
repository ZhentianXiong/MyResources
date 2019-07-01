package JZoffer;

// 0-(n-1)中缺失的数字：    一个长度为n-1的递增排序数组中的左右数字都是唯一的，并且都在范围0-n-1内，则n个数字中只有一个数字不在数组内，找出来
public class T53_MissingNumber_2 {

    public static void main(String[] args){
        int[] a = {0,1,2,3,4};
        System.out.println(findMissingNumber2(a));
    }

    public static int findMissingNumber(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        return binarySearch(array,0,array.length-1);
    }

    public static int binarySearch(int[] array,int low,int high){
        if(low > high){
            return -1;
        }

        int mid = low+(high-low)/2;
        if(array[mid] == mid){
            return binarySearch(array,mid+1,high);
        }else{
            //记得检查中点左边的数字，若该中点数即为缺失的数字，则左边将找不到缺失的数字了
            if(mid>0 && array[mid-1] > (mid-1)){
                return binarySearch(array,low,mid-1);
            }else{
                return mid;
            }
        }
    }

    //解法2：  循环实现
    public static int findMissingNumber2(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int n = array.length;
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + ((end - start)>>1);
            if(array[mid] != mid){
                if(mid == 0 || array[mid-1] == mid-1){
                    return mid;
                }
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start == n ? n : -1;
    }


}
