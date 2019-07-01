package JZoffer;

//求1+2+3+...+n:   不能使用乘除法、for\while\if\else\switch\case等关键字及条件判断语句
//可以使用的运算符有：   单目运算符：++和--,双目运算符：+,-，移位（没有规律性）运算符<<和>>，关系运算符>,<等，逻辑运算符&&，||,&,|,^，赋值=
//   && ||  短路特性，前面已经有结果时就不会执行后面的语句
public class T64_SumOf1ToN {

    public static void main(String[] args){
        System.out.println(sum(10));
    }

    //解法1
    public static int sum(int n){
        int sum = n;
        boolean flag = (n>0) && ((sum += sum(n-1))>0);
        return sum;
    }

    //解法2
    public static int sum2(int n){
        return (int)(Math.pow(n,2)+n)>>1;
    }

}
