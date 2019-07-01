package JZoffer;

import java.util.LinkedList;
import java.util.Queue;

//用两个队列来实现一个栈
//两个队列内元素顺序一样，另一个队列只做缓冲存储
//注意队列长度在不断变化，不能直接把.size（）或.length（）直接放在for/while语句条件里面
public class T09_twoQueueToStack {

    static Queue<Integer> queue1 = new LinkedList<Integer>();
    static Queue<Integer> queue2 = new LinkedList<Integer>();

    public static void push(int value)
    {
        if(queue2.isEmpty())queue1.add(value);
        else queue2.add(value);
    }

    public static int pop()
    {
        if(queue1.isEmpty())
        {
            //若两个队列都为空，则不允许弹出操作
            if(queue2.size() == 0)return -1;
            int len = queue2.size();
            for(int i=1;i<len;i++)
            {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else
        {
            int len = queue1.size();
            for(int i=1;i<len;i++)
            {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }

    public static void main(String[] args)
    {
        System.out.println(pop());
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }


}
