package algorithms4;

import java.util.Iterator;

//Item用来帮助指定任意类型的对象
//Iterable接口用来进行迭代
public class arrayToStack<Item> implements Iterable<Item>{

    private Item[] a = (Item[]) new Object[1];//栈的大小
    private int N = 0;//栈中元素数量

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    //动态调整栈的大小
    private void resize(int relength)
    {
        Item[] temp = (Item[]) new Object[relength];
        for(int i = 0; i < N; i++)
        {
            temp[i] = a[i];
        }
        a = temp;
    }

    //压入操作：先检查栈的大小是否已满，满的话则扩大一倍再进行压入，每次操作第N+1个数，即a[N]
    public void push(Item item){
        if(N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    
    //弹出操作，每次操作的一定是第N个数，即a[N-1]
    public Item pop()
    {
        Item item = a[--N];
        a[N] = null;//避免对象游离，弹出的对象不会再使用，置null，利于JVM垃圾回收
        if(N>0 && N==a.length/4) resize(a.length/2);//若栈的长度过长，则进行减半
        return item;
    }

    //返回一个Iterator迭代对象
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }

    //实现接口中定义的方法，只是迭代访问，不能进行删除操作
    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        public boolean hasNext()
        {
            return i > 0;
        }
        public Item next()
        {
            return a[--i];
        }
        public void remove()
        {

        }
    }

}
