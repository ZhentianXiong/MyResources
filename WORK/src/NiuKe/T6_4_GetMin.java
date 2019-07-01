package NiuKe;

public class T6_4_GetMin {

    public int getMin(int[] arr, int n) {
        // write code here
        if(arr == null || arr.length == 0){
            return Integer.MIN_VALUE;
        }

        if(arr[0] < arr[arr.length-1]){
            return arr[0];
        }
        return binary(arr,0,arr.length-1);
    }

    public int binary(int[] a,int low,int high){
        int mid = low + (high-low)/2;
        if(low+1 == high)return a[high];
        if(a[mid] == a[low] && a[mid] == a[high]){
            return min(a,low,high);
        }

        if(a[mid] >= a[low]){
            return binary(a,mid,high);
        }else{
            if(a[mid] <= a[high]){
                return binary(a,low,mid);
            }else{
                return -1;
            }
        }
    }

    public int min(int[] a,int left,int right){
        int min = a[left];
        for(int i = left;i<=right;i++){
            if(a[i] < min){
                min = a[i];
            }
        }
        return min;
    }


}
