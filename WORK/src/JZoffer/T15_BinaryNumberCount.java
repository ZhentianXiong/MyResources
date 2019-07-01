package JZoffer;

//二进制中1的个数：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
//利用整数 1，依次左移每次与 n 进行与运算，若结果不为0，说明这一位上数字为 1，++cnt。
//此解法 i 需要左移 32 次。
//不要用 n 去右移并与 1 进行与运算，因为n 可能为负数，右移时会陷入死循环。
public class T15_BinaryNumberCount {

    public static int NumberOf1(int n)
    {
        int sum=0;
        int i=1;
        while(i != 0)
        {
            //注意判断条件，不能是等于1 ，而要是不等于0
            if((n&i) != 0){sum++;}
            //i左移一位
            i<<=1;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(NumberOf1(10));
    }

}
