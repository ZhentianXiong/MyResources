package LintCode;

public class T2_458_TargetLastLocation {

    public int lastPosition(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length;
        int last = -1;

        while(start < nums.length && end >= 0 && start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] < target){
                start = mid+1;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                last = mid;
                start = mid+1;
            }
        }
        return last;
    }


}
