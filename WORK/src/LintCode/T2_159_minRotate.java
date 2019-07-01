package LintCode;

public class T2_159_minRotate {

    //山峰型数组找峰值不要直接二分，要找相邻的两个数出来再进行比较

    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }

        int low = 0;
        int high = nums.length-1;
        while(low+1 < high){
            int mid = (low+high)/2;
            if(nums[mid] >= nums[nums.length-1]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return Math.min(nums[low],nums[high]);
    }

}
