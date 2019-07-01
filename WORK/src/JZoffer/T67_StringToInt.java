package JZoffer;

//字符串转换为整数：   注意考虑很多特殊情况， 空，+，-，特殊符号，溢出
public class T67_StringToInt {

    //true为非法输入
    public static boolean flag = false;
    public static int strToInt(String str){
        if(str == null || str.length() == 0 || str.trim().equals("")){
            flag = true;
            return 0;
        }

        if(str.length() == 1 && (str.equals("+") || str.equals("-"))){
            return 0;
        }

        //false为负数
        boolean symbol = true;
        char[] chars = str.trim().toCharArray();
        int index = 0;
        if(chars[0] == '+'){
            index++;
        }

        if(chars[0] == '-'){
            index++;
            symbol = false;
        }

        int sum = 0;
        for(int i = index;i<chars.length;i++){
            if(chars[i] < '0' || chars[i] > '9'){
                flag = true;
                return 0;
            }

            //检查是否溢出
            int temp = sum*10 + (chars[i]-'0');
            if((temp - (chars[i]-'0'))/10 != sum){
                flag = true;
                return 0;
            }

            sum = sum*10 + (chars[i] - '0');
        }

        if(symbol == false)sum = -sum;
        return sum;
    }



}
