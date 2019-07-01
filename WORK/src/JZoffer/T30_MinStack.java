package JZoffer;

//包含min函数的栈:    定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//思路：  定义两个栈， 一个正常存储数据， 一个只存储当前的最小值  两个栈同步压入和弹出
import javax.management.RuntimeErrorException;
import java.util.Stack;

public class T30_MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minstack.isEmpty()){
            minstack.push(node);
        }else{
            minstack.push(Math.min(minstack.peek(),node));
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minstack.pop();
        }else{
            throw new RuntimeException("Stack is empty!");
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }else{
            return 0;
        }
    }

    public int min() {
        if(!minstack.isEmpty()){
            return minstack.peek();
        }else{
            return 0;
        }
    }

}
