package JZoffer;

//表示数值的字符串：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
//思路：可抽象为：  A.B e/E C     A：可为正负null  B：可没有，只能为正  C：可为正负  .E 后面必须要有数  整数为空则小数不能为空
//判断字符为数字的方法  ： str[i] >= '0' && str[i] <= '9'
public class T20_StringISNumeric {

    //正则表达式：
    //[]  ： 字符集合
    //()  ： 分组
    //?   ： 重复 0 ~ 1
    //+   ： 重复 1 ~ n
    //*   ： 重复 0 ~ n
    //.   ： 任意字符
    //\\. ： 转义后的 .
    //\\d ： 数字
    public static boolean isNumeric2(char[] str){
        return str != null
                && str.length != 0
                && new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }


    public static boolean isNumeric(char[] str){
        if(str == null || str.length < 1){
            return false;
        }

        int i = 0;

        //判断第一个数是否为符号
        if(str[i] == '-' || str[i] == '+'){
            i++;
            //若只有符号，则不为数
            if(i == str.length){
                return false;
            }
        }

        //一直跳过数字，直到找到特殊字符 .eE  注意先比较长度再取值，防止数组越界
        while(i<str.length && str[i] != '.' && str[i] != 'e' && str[i] != 'E'){
            if(str[i] >= '0' && str[i] <= '9') {
                i++;
            }else{
                return false;
            }
        }

        //如果特殊字符是 .
        if(i<str.length && str[i] == '.'){
            i++;
            //.后面没有，false
            if(i == str.length){
                return false;
            }
        }

        while(i<str.length && str[i] != 'e' && str[i] != 'E'){
            if(str[i] >= '0' && str[i] <= '9') {
                i++;
            }else{
                return false;
            }
        }

        //下一位为 e/E
        if(i<str.length && (str[i] == 'e' || str[i] == 'E')){
            i++;
            //e/E后面没有，false
            if(i >= str.length){
                return false;
            }

            if(str[i] == '-' || str[i] == '+'){
                i++;
            }

            if(i >= str.length){
                return false;
            }

            while(i<str.length){
                if(str[i] >= '0' && str[i] <= '9'){
                    ++i;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[] test = "13.14e15".toCharArray();
        System.out.println(isNumeric2(test));
    }

}
