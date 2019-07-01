package NiuKe;

public class T6_3_findLeftest {

    public int findPos(int[] arr, int n, int num) {
        // write code here
        if(arr == null || arr.length == 0){
            return -1;
        }

        int locate = -1;
        return binary(arr,0,arr.length-1,num,locate);
    }

    public int binary(int[] a,int start,int end,int num,int locate){
        if(start > end){
            return locate;
        }

        int mid = start + (end-start)/2;
        if(a[mid] == num){
            locate = mid;
            return binary(a,start,mid-1,num,locate);
        }else{
            if(a[mid] < num){
                return binary(a,mid+1,end,num,locate);
            }else{
                return binary(a,start,mid-1,num,locate);
            }
        }
    }

}
