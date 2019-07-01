package JZoffer;

import java.util.Stack;

//栈的压入、弹出序列：    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
//例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
//思路：每次压入一个数后就判断是否可以弹出，一直到不能弹出为止，再进行压入
public class T31_StackPushPopOrder {

    public static boolean isPopOrder(int[] pushA, int[] popA){

        if(pushA == null || popA == null || popA.length != pushA.length){
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int poplen = 0;

        for(int i = 0; i < pushA.length;i++){
            stack.push(pushA[i]);

            //注意判断条件中先判断栈是否为空
            while(!stack.isEmpty() && stack.peek() == popA[poplen]){
                stack.pop();
                poplen++;
            }
        }

        if(poplen == popA.length)return true;
        else return false;

    }


}
