package JZoffer;

//数字在排序数组中出现的次数：    统计一个数字在排序数组中出现的次数。例如输入排序数组 [1, 2, 3, 3, 3, 3, 4, 5] 和数字 3，由于 3 在这个数组中出现了 4 次，因此输出 4。
//思路：利用排序数组的性质，递归用 二分查找 ，
public class T53_FindNumberInSortedArray_1 {

    public static int getNumberOfK(int[] array, int k){
        if(array == null || array.length < 1){
            return 0;
        }

        //找到这个数字开始的首位坐标即可得出个数
        int start = binarySearchFirst(array,0,array.length-1,k);
        int end = binarySearchLast(array,0,array.length-1,k);
        if(start == -1 && end == -1)return 0;
        return end-start+1;
    }

    public static int binarySearchFirst(int[] array, int low, int high, int k){
        if(low > high || low < 0 || high >= array.length){
            return -1;
        }

        int mid = (low+high)/2;
        if(array[mid] < k){
            return binarySearchFirst(array,mid+1,high,k);
        }else{
            if(array[mid] > k){
                return binarySearchFirst(array,low,mid-1,k);
            }else{
                //第一个数左边为空或不为k， 防止左半部分不存在了返回 -1
                if(mid>0 && array[mid-1] == k){
                    return binarySearchFirst(array,low,mid-1,k);
                }else{
                    return mid;
                }
            }
        }
    }


    public static int binarySearchLast(int[] array, int low, int high, int k){
        if(low > high || low < 0 || high >= array.length){
            return -1;
        }

        int mid = (low+high)/2;
        if(array[mid] < k){
            return binarySearchLast(array,mid+1,high,k);
        }else{
            if(array[mid] > k){
                return binarySearchLast(array,low,mid-1,k);
            }else{
                //最后一个数右边为空或不为K ， 防止返回 -1
                if(mid<array.length-1 && array[mid+1] == k){
                    return binarySearchLast(array,mid+1,high,k);
                }else{
                    return mid;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK(a,3));
    }


}
