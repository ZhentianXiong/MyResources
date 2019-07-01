package JZoffer;

//数组中重复的数字：    在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
//例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
public class T69_RepeatNumberInArray {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length < 2 || length != numbers.length){
            return false;
        }

        for(int e : numbers){
            if(e > length-1){
                return false;
            }
        }

        boolean[] exist = new boolean[length];
        for(int e : numbers){
            if(exist[e] == true){
                duplication[0] = e;
                return true;
            }
            exist[e] = true;
        }
        return false;
    }


}
