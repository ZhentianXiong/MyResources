package JZoffer;

//从 1 到 N 整数中 1 出现的次数：    输入一个整数 N ，求 1-N 这N个整数的十进制表示中1出现的次数
//数学归纳法，找规律 以 12013/12113/12213为例，每次考虑第 i 位上出现 1 的次数   时间复杂度只有 O（log n）
//某位上为 0 ：= 高位*位数             （如 （0-11）12*100）
//某位上为 1 ：= 高位*位数 + （低位+1）  （如  12*100 + （13+1））
//某位大于 1 ：= （高位+1）*位数        （如（0-12）13*100）
public class T43_NumberOf1 {

    public static int numberOf1(int n){

        if(n < 0){
            n = Math.abs(n);
        }

        int result = 0;
        int i = 1;
        //高位，当前位，低位
        int high = 1, cur = 1, low = 1;

        while(high != 0){
            low = n % i;
            high = n/(i*10);
            cur = n/i - high*10;

            if(cur == 0){
                result += high*i;
            }else{
                if(cur == 1){
                    result =result + high*i + (low + 1);
                }else{
                    result += (high+1)*i;
                }
            }
            //每次往前一位，扩大10倍
            i *= 10;
        }
        return result;
    }


}
