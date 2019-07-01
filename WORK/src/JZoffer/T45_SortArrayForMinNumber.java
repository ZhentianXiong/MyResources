package JZoffer;

//把数组排成最小的数：   输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
//思路：全排列 N的阶乘 时间复杂度太慢，不考虑；本质是判断两个数字 m,n 的排列形式 mn nm 哪个更小，但是用整型拼接起来可能会溢出，所以用字符串比较
import java.util.Arrays;

public class T45_SortArrayForMinNumber {

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }

        String[] str = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }

        //字符串数组升序排列
        Arrays.sort(str,((o1, o2) -> (o1+o2).compareTo(o2+o1)));

        StringBuilder result = new StringBuilder();
        for(String e : str){
            result.append(e);
        }
        return result.toString();
    }

}
