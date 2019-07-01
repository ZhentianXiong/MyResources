package JZoffer;

//数组中唯一出现一次的数字：    在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。
//解法1 ： 哈希表 时间复杂度 o(n)   空间复杂度  o(n)
//解法2：  位运算， 每个数出现3次， 则吧所有数化成二进制，每一位对应相加%3 则是只出现一次的那个数（int 32位）时间复杂度o(n) 空间复杂度o(1)
public class T56_NumberAppearOnce_2 {

    public static int numberAppearOnce(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        //统计所有树所有位分别的和
        int[] sum = new int[32];

        for(int e : array){
            int index = 0;
            while(index < 32){
                sum[index] += (e & 1);
                index++;
                e >>= 1;
            }
        }

        int result = 0;
        for(int i = 0;i<sum.length;i++){
            result += (sum[i]%3)*Math.pow(2,i);
        }

        return result;
    }




    public  static void main(String[] args){
        System.out.println(numberAppearOnce(new int[]{-2,-2,-2,1,1,1,3,5,5,5}));
    }


}
