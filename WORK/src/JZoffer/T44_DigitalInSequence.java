package JZoffer;

//？？？？？？ 不要轻易放弃尝试，可以向面试官要提示
//数字序列中某一位的数字   ：     数字以   01234567891011121314。。。的格式序列化到一个字符序列中，第0位是0，第5位是5，第13位是1，第1001位是7
//思路：考虑到时间复杂度，不能完全遍历；要找到规律跳过某些数字 O（log n） ： 0-9： 10位  10-99：90*2=180位  100-999：900*3=2700位
//以1001为例： 1001-10=991    991-180=811   811<2700，所以一定是三位数 811/3=270...1 即从100往后270个数（370）的往后一位7
public class T44_DigitalInSequence {

    public static int digitalInSequence(int n){
        if(n<0){
            return -1;
        }

        if(n<10){
            return n;
        }

        //-10：10中的1从（0，0）开始，往后移 商 位，找到树后在往后移 余数 位
        n -= 10;
        int i = 2;
        while(n > 9*Math.pow(10,(i-1))*i){
            n -= 9*Math.pow(10,(i-1))*i;
            i++;
        }

        // i 位的第 x 个数
        int x = n/i;
        // i 位的第 x 个数的第 y 位
        int y = n%i;

        int z = (int)(1*Math.pow(10,i-1)) + x;

        //该数有 i 位，取出其中第 y 位
        int result = 0;
        while(y >= 0){
            result = z / (int)Math.pow(10,i-1);
            z = z % (int)Math.pow(10,i-1);
            y--;
            i--;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(digitalInSequence(19));
    }

}
