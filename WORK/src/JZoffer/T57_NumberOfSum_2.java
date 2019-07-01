package JZoffer;

import java.util.ArrayList;

//和为 S 的连续整数序列：   输入一个正数 S ，输出所有和为S的连续正数序列（至少含有两个数）
//思路：   知识迁移，受上一题的启发，用两个指针遍历（都从头开始，一前一后） 直至小的数大于 S 的一半即可（因为最少两个数）
public class T57_NumberOfSum_2 {

    public static ArrayList<ArrayList<Integer>> continueSequenceWithSum(int sum){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum < 3){
            return result;
        }

        int low = 1;
        int high = 2;

        while(low <= sum/2){
            if(sum(low,high) == sum){
                result.add(add(low,high));
                low++;
            }else{
                if(sum(low,high) > sum){
                    low++;
                }else{
                    high++;
                }
            }
        }
        return result;
    }

    public static int sum(int low, int high){
        int sum = 0;
        for(int i = low;i<=high;i++){
            sum += i;
        }
        return sum;
    }

    public static ArrayList<Integer> add(int low, int high){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=low;i<=high;i++){
          result.add(i);
        }
        return result;
    }


}
