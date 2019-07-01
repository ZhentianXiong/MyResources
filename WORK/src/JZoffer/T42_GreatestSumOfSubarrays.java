package JZoffer;

//连续子数组的最大和   ：在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
//例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和。(子向量的长度至少是1)
//时间复杂度为 O（N）
//动态规划：若前面累加和大于0，则加上前面的数；若累加和小于0，则直接等于目前处理元素
//写出递归公式，用循环来实现
public class T42_GreatestSumOfSubarrays {

    public static int biggestSumOfSubarrays(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int max = array[0];
        //表示当前处理的元素之前的最大累加和
        int fi = array[0];

        for(int i = 1; i<array.length;i++){
            if(fi <= 0){
                fi = array[i];
            }else{
                fi += array[i];
            }
            //一直更新最大值直至最后
            max = Math.max(max,fi);
        }
        return max;
    }

}
