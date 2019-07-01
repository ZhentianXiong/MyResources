package NiuKe;

public class T6_2_LocalSmall {

    public int getLessIndex(int[] arr) {
        if(arr == null || arr.length == 0){
            return -1;
        }

        if(arr.length == 1){
            return 0;
        }

        int n = arr.length-1;

        if(arr[0] < arr[1]){
            return 0;
        }

        if(arr[n-1] > arr[n]){
            return n;
        }

        return binary(arr,0,n);

    }

    public int binary(int[] a,int start,int end){
        if(start >= end){
            return -1;
        }

        int mid = start + (end-start)/2;
        if(a[mid] < a[mid-1] && a[mid] < a[mid+1]){
            return mid;
        }else{
            if(a[mid] > a[mid-1]){
                return binary(a,start,mid);
            }else{
                return binary(a,mid,end);
            }
        }
    }

}
