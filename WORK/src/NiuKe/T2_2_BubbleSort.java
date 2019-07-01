package NiuKe;

public class T2_2_BubbleSort {

    //冒泡排序
    public int[] bubbleSort(int[] A, int n) {
        // write code here
        if(A.length != n){
            return null;
        }

        boolean exchange;
        for(int i=0;i<n-1;i++){
            exchange = false;
            for(int j=1;j<n-i;j++){
                if(A[j-1] > A[j]){
                    swap(A,j,j-1);
                    exchange = true;
                }
            }
            if(exchange == false)break;
        }
        return A;
    }

    public void swap(int[] a, int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
