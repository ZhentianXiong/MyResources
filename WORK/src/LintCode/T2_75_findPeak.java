package LintCode;

public class T2_75_findPeak {

    public int findPeak(int[] num) {
        // write your code here

        int low = 1;
        int high = num.length-2;

        while(low+1 < high){
            int mid = (low+high)/2;
            if(num[mid] > num[mid-1] && num[mid] > num[mid+1]){
                return mid;
            }else{
                if(num[mid] < num[mid-1]){
                    high = mid;
                }else{
                    low = mid;
                }
            }
        }

        if(num[low]>num[high]){
            return low;
        }else{
            return high;
        }
    }

}
