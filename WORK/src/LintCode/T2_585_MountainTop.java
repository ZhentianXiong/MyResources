package LintCode;

public class T2_585_MountainTop {

    public int mountainSequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length-1;
        //到相邻时就结束，找出可能最大的两个值
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] <= nums[mid+1]){
                start = mid;
            }else{
                end = mid;
            }
        }
        return Math.max(nums[start],nums[end]);
    }


}
