package NiuKe;

public class T2_4_InsertSort {

    public int[] insertionSort(int[] A, int n) {
        // 插入排序
        if(A.length != n){
            return null;
        }

        int temp;
        int j;
        for(int i=1;i<n;i++){
            temp = A[i];
            for(j=i;j>0 && A[j-1] > temp;j--){
                A[j] = A[j-1];
            }
            A[j] = temp;


//            for(int j=i-1;j>=-1;j--){
//                if(j == -1 || A[j]<temp){
//                    A[j+1] = temp;
//                    break;
//                }else{
//                    A[j+1] = A[j];
//                }
//            }


        }
        return A;
    }
}
