package JZoffer;

//数值的整数次方：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public class T16_IntegerPower {

    //第一种方法，直接排除完特殊情况，然后按指数大小做很多次乘法即可
    public double Power(double base, int exponent) {
        double sum = 1;
        if(base == 0) {
            return 0;
        }

        if(exponent > 0){
            for(int i = 0; i < exponent; i++){
                sum *= base;
            }
        } else{
            for(int i = 0; i < (-exponent); i++)
            {
                sum *= base;
            }
            sum = 1.0/sum;
        }
        return sum;
    }

    //第二种方法，用递归，32次方等于16次方乘以16次方
    public static double Power2(double base, int exponent)
    {
        //排除特殊情况
        if(base == 0){
            return 0;
        }

        if(exponent == 1){
            return base;
        }

        if(exponent == 0){
            return 1;
        }

        //N次方等于两个N/2次方的乘积，注意除法可以用右移一位来代替
        double result = Power2(base, Math.abs(exponent)>>1)*Power2(base, Math.abs(exponent)>>1);
        //和1做 与 的移位运算可以判断奇偶数
        if((exponent & 1) == 1){
            result*=base;
        }

        //负数的情况
        if(exponent<0){
         result = 1.0/result;
        }

        return result;

    }

    public static void main(String[] args)
    {
        System.out.println(Power2(2,-4));
    }


}
