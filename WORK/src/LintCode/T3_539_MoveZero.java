package LintCode;

public class T3_539_MoveZero {

    public void moveZeroes(int[] nums) {
        // write your code here
        int zero = 0;
        int nonzero = 0;

        int len = nums.length;

        while(zero < len && nonzero < len){
            while(zero < len && nums[zero] != 0){
                zero++;
            }

            nonzero = zero+1;
            while(nonzero < len && nums[nonzero] == 0){
                nonzero++;
            }

            int temp = nums[zero];
            nums[zero] = nums[nonzero];
            nums[nonzero] = temp;
        }

    }



}
