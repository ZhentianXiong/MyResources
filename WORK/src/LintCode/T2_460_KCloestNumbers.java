package LintCode;

public class T2_460_KCloestNumbers {

    public int[] kClosestNumbers(int[] arr, int target, int k) {
        // write your code here
        int[] res = new int[k];
        if(arr == null || arr.length == 0 || k <= 0){
            return res;
        }

        int start = 0;
        int end = arr.length-1;

        while(start + 1 < end){
            int mid = (start + end)/2;
            if(arr[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }

        for(int i=0;i<k;i++){
            if(start < 0){
                res[i] = arr[end];
                end++;
                continue;
            }

            if(end >= arr.length){
                res[i] = arr[start];
                start--;
                continue;
            }

            if(Math.abs(target-arr[start]) <= Math.abs(target-arr[end])){
                res[i] = arr[start];
                start--;
            }else{
                res[i] = arr[end];
                end++;
            }
        }

        return res;
    }

}


// 第一步：用二分法找到离target最近的两个位置
/*
        while(start + 1 < end){
        int mid = start + (end - start) / 2;
        if(A[mid] >= target){
        end = mid;
        }
        else{
        start = mid;
        }

        }*/
