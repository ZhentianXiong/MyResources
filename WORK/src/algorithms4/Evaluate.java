package algorithms4;

import java.util.Scanner;
import java.util.Stack;

//用双栈结构进行简单的数学运算:数字栈+符号栈
//从命令行进行输入（按优先级都要加上括号，最外面也要如： （ 1 + （ （ 2 + 3 ） * （ 4 * 5 ） ） ），读取一行，以空格为分隔符生成字符串数组
//算式中共有三种类型，数字、加减乘除、括号（左括号不作处理，右括号要进行运算）
//栈的底层用数组来实现
public class Evaluate {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Stack<String> symbol = new Stack<String>();
        Stack<Double> number = new Stack<Double>();
        String[] tem = input.nextLine().split(" ");
        for(int i=0;i<tem.length;i++)
        {
            String temp = tem[i];
            if (temp.equals("(")) ;
            else if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/") || temp.equals("sqrt")) symbol.push(temp);
            else if (temp.equals(")")) {
                double num = number.pop();
                String syb = symbol.pop();
                if(syb.equals("+")) number.push(num + number.pop());
                else if(syb.equals("-")) number.push(number.pop() - num);
                else if(syb.equals("*")) number.push(num * number.pop());
                else if(syb.equals("/")) number.push(number.pop() / num);
                else if(syb.equals("sqrt")) number.push(Math.sqrt(num));
            }
            else number.push(Double.parseDouble(temp));
        }

        System.out.println(number.pop());

    }

}
