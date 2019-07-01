package JZoffer;

//数组中出现次数超过一半的数字   --- 解法2
//根据数组规律，采用两两不同相互抵消的策略，最后剩下的一定是出现大多数的那个数
//时间复杂度也是  O（n）  而且不需要修改数组
public class T39_MoreThanHalfNumber_2 {

    public static void main(String[] args){
        int[] array = {1,2,3,2,2,2,5,4,2};
        int val = moreThanHalfNumber(array);
    }

    public static int moreThanHalfNumber(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }

        //当前占大多数的值   未被消掉
        int res = array[0];
        //余下的次数
        int num = 1;

        for(int i = 1;i<array.length;i++){
            if(num == 0){
                //为空了，直接补上下一个
                res = array[i];
                num++;
            }else{
                if(array[i] == res){
                    //相等则累加次数
                    num++;
                }else{
                    //不等做抵消
                    num--;
                }
            }
        }

        int number =0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == res)number++;
        }

        if(number > array.length/2)return res;
        else return 0;
    }



}
