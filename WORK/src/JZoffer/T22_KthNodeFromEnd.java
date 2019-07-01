package JZoffer;

import java.util.Stack;

//链表中倒数第K个节点：      输入一个链表，输出该链表中倒数第k个结点。
//第二种方法更好，只需要遍历一遍链表
//类似：求链表的中间节点 ： 奇数返回中间那个，偶数返回中间两个的任意一个  定义两个指针，一个一次走一步，一个一次走两步
public class T22_KthNodeFromEnd {

    public static class ListNode
    {
       int val;
       ListNode next;

       ListNode(int val)
       {
           this.val = val;
       }
    }

    //方法1：用栈的结构，这样不好
    public static ListNode FindKthToTail(ListNode head, int k){
        if(k<1 || head == null){
            return null;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        while(head.next != null){
            stack.push(head);
            head = head.next;
        }
        stack.push(head);

        if(k>stack.size()){
            return null;
        }else{
            while(k>1){
                stack.pop();
                k--;
            }
            return stack.pop();
        }
    }

    //方法2：再找一个指针，先往后移 k-1 步（如果存在的话，不存在直接null） 如果第二个指针还没到结尾，则把两个指针依次往后移，直至最后
    public static ListNode FindKthToTail2(ListNode head, int k){
        //访问空指针指向的内存会造成程序崩溃
        if(k<1 || head == null){
            return null;
        }

        ListNode tail = head;
        while(k>1){
            //如果链表长度小于 k 直接返回null
            if(tail.next != null) {
                tail = tail.next;
                k--;
            }else{
                return null;
            }
        }

        while(tail.next != null){
            tail = tail.next;
            head = head.next;
        }
        return head;
    }


    public static void main(String[] args){

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        System.out.println(FindKthToTail2(root,3).val);
    }

}
