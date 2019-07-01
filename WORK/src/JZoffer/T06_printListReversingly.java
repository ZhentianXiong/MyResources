package JZoffer;

import java.util.ArrayList;
import java.util.Stack;

//输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
//因为链表只能从前往后遍历，本题要从后往前输出，即后到的先打印，复合栈的性质
//所以遍历链表，用栈存储，然后弹出到动态数组
//栈 递归
public class T06_printListReversingly {

    public static class ListNode
    {
        int val;
        ListNode next = null;

        ListNode(int val)
        {
            this.val = val;
        }
    }

    //用栈结构-推荐
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        //注意健壮性和完整性：当输入为空时直接返回空动态数组
        if(listNode == null) return arraylist;
        Stack<Integer> stack = new Stack<Integer>();
        while(listNode.next != null)
        {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        stack.push(listNode.val);
        while(!stack.empty())arraylist.add(stack.pop());
        return arraylist;
    }

    //用递归结构，不推荐，链表过长容易发生stack overflow
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arraylist = new ArrayList<>();
        if(listNode == null)return arraylist;
        digui(listNode,arraylist);
        return arraylist;
    }

    public static void digui(ListNode listnode, ArrayList<Integer> arraylist)
    {
        if(listnode.next != null) digui(listnode.next,arraylist);
        arraylist.add(listnode.val);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);


        System.out.println(printListFromTailToHead(root).toString());
        System.out.println(printListFromTailToHead2(root).toString());
    }



}
