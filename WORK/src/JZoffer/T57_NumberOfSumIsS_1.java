package JZoffer;

import java.util.ArrayList;

//和为 S 的两个数字：  输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
//思路： 两层遍历 o(n^2)
//思路： 先选择两个数字（两个指针从最前最后往中间靠拢），和相等则直接输出，和大于特定值则减小（从更大的数开始减小），和小于特定值则增加（从更小的数开始增加）
// 时间复杂度： o(n)
public class T57_NumberOfSumIsS_1 {

    public static ArrayList<Integer> twoNumbersOfSumIsS(int[] array,int sum){

        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length < 2){
            return result;
        }

        int low = 0;
        int high = array.length-1;

        while(low < high && (array[low] + array[high]) != sum){
            if(array[low] + array[high] > sum){
                high--;
            }else{
                low++;
            }
        }

        if((array[low] + array[high]) == sum){
            result.add(array[low]);
            result.add(array[high]);
        }

        return result;
    }


}
