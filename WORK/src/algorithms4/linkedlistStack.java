package algorithms4;

import java.util.*;

//test: to be or not to - be - - that - - - is
//用单向链表实现栈结构
//first位于栈顶，next从上指到下👇（以first为准，从first方向指出）
public class linkedlistStack {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] temp = input.nextLine().split(" ");
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < temp.length; i++)
        {
            if(!temp[i].equals("-")) stack.push(temp[i]);
            else if(!stack.isEmpty()) System.out.println(stack.pop());
        }
        System.out.println(stack.size());
    }

}


class Stack<Item>
{
    private class Node
    {
        Item item;
        Node next;
    }

    private Node first;
    private int n;

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return n;
    }

    //先用temp first指向first，再新建first节点，最后用first指向之前的节点
    public void push(Item item)
    {
        Node tempfirst = first;
        first = new Node();
        first.item = item;
        first.next = tempfirst;
        n++;
    }

    //直接用first指向first.next
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

}