package algorithms4;

import java.util.Scanner;

//test: to be or not to - be - - that - - - is
//first位于队列头，last位于队列尾（以first为准，从first方向指出）
//头尾两个指针，队列为空时注意处理插入操作，队列为空不允许弹出操作，队列未1时注意处理弹出操作
public class linkedlistQueue {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] temp = input.nextLine().split(" ");
        Queue<String> queue = new Queue<String>();
        for(int i=0;i<temp.length;i++)
        {
            if(!temp[i].equals("-")) queue.enqueue(temp[i]);
            else if(!queue.isEmpty()) System.out.println(queue.dequeue());
        }
        System.out.println(queue.size());
    }

}



class Queue<Item>
{
    private class Node
    {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int n;

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    //先建立指针指向之前最后节点，然后建立最后节点，再用倒数第二指向最后节点
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        n--;
        if(n == 0) last = null;
        return item;
    }

}