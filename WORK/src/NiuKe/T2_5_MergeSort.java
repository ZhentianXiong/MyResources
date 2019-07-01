package NiuKe;

public class T2_5_MergeSort {

    public int[] mergeSort(int[] A, int n) {
        // write code here
        if(A.length != n){
            return null;
        }

        int low = 0;
        int high = n-1;
        int[] copy = new int[A.length];
        sort(A,low,high,copy);
        return A;
    }

    public void sort(int[] a,int low,int high,int[] copy){
        int mid = (low+high)/2;
        if(low>=high)return;
        sort(a,low,mid,copy);
        sort(a,mid+1,high,copy);
        merge(a,low,mid,high,copy);
    }

    public void merge(int[] a,int low,int mid,int high,int[] copy){
        if(low>=high)return;
        for(int i=low;i<=high;i++){
            copy[i] = a[i];
        }

        int i = low;
        int j = mid+1;
        int k = low;
        while(i<=mid && j<=high){
            if(copy[i] <= copy[j]){
                a[k++] = copy[i++];
            }else{
                a[k++] = copy[j++];
            }
        }

        while(i<=mid){
            a[k++] = copy[i++];
        }

        while(j<=high){
            a[k++] = copy[j++];
        }
    }
}
