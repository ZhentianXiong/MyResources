package algorithms4;

import java.util.Iterator;
import java.util.Scanner;

//基础数据结构：优点-缺点
//数组：通过索引可以直接访问任意元素-----初始化时就要知道元素的数量
//链表：使用空间大小与元素数量成正比-----需要通过引用访问任意元素
public class linkedlistBag {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] temp = input.nextLine().split(" ");
        Bag<String> bag = new Bag<String>();
        for (int i = 0; i < temp.length; i++) {
            bag.add(temp[i]);
        }
        System.out.println(bag.size());
        for(String e : bag)
        {
            System.out.println(e);
        }
    }

}


class Bag<Item> implements Iterable<Item>
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
    public void add(Item item)
    {
        Node tempfirst = first;
        first = new Node();
        first.item = item;
        first.next = tempfirst;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Listiterator();
    }

    class Listiterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        {
            return current != null;
        }
        public void remove()
        { }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
