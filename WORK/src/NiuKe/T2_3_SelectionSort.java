package NiuKe;

public class T2_3_SelectionSort {
    public int[] selectionSort(int[] A, int n) {
        // 选择排序
        if(A.length != n){
            return null;
        }

        int min;
        for(int i=0;i<n-1;i++){
            min = i;
            for(int j=i+1;j<n;j++){
                if(A[j] < A[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }
        }

        return A;
    }
}
