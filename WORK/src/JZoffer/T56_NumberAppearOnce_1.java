package JZoffer;

//数组中数字出现的次数：  数组中只出现一次的两个数字   一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//如果数组中所有数字都出现两次，只有一个出现一次：   先把所有数字异或，则一定得到两个所求树的异或（a^a=0），结果转换为二进制一定有一位是1，找到这位1的坐标index
//然后遍历所有元素，该坐标下index为1的分一堆，为0的分一堆，在分别做异或即可得出两个数  时间复杂度 O（N）  空间复杂度 O（1）
public class T56_NumberAppearOnce_1 {

    public void numberAppearOnce(int[] array, int num1[], int num2[]){
        if(array == null || array.length < 2){
            return;
        }

        int result = 0;
        for(int e : array){
            result = result ^ e;
        }

        int index = firstindexOf1(result);
        for(int e : array){
            if(indexIs1(e,index)){
                num1[0] ^= e;
            }else{
                num2[0] ^= e;
            }
        }
    }

    //定位二进制中为1的那一位的坐标
    public static int firstindexOf1(int num){
        int index = 0;
        while((num & 1) == 0){
            num = num >> 1;
            index++;
        }
        return index;
    }

    //判断所有数那一位是1/0
    public static boolean indexIs1(int num, int index){
        num = num >> index;
        return (num & 1) == 1;
    }


}
