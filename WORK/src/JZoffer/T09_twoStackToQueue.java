package JZoffer;

import java.util.Stack;

//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//一个栈存储队列的插入，即是顺序的（3，2，1）3（栈顶）后插入
//另一个栈存储用于弹出的数据，即是倒序的（1，2，3）1（栈顶）先弹出(两个栈内元素顺序不一样)
//插入时，直接加入栈1；弹出使检查栈二是否为空，不为空弹出栈顶，为空则把栈1的全部弹出压入栈二
public class T09_twoStackToQueue {

        static Stack<Integer> stack1 = new Stack<Integer>();
        static Stack<Integer> stack2 = new Stack<Integer>();

        public static void push(int node)
        {
            stack1.push(node);
        }

        public static int pop()
        {
            if(!stack2.empty())return stack2.pop();
            else if(stack1.empty())return -1;
            else{
                while(!stack1.empty())
                {
                    stack2.push(stack1.pop());
                }
                return pop();
            }
        }

        public static void main(String[] args)
        {
            push(3);
            push(4);
            push(5);
            push(6);
            System.out.println(pop());
            System.out.println(pop());
            System.out.println(pop());
            System.out.println(pop());
        }


}
