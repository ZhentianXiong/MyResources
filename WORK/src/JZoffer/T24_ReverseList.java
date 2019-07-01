package JZoffer;

//反转链表： 输入一个链表，反转链表后，输出新链表的表头。
//1->2->3 反转为: 1<-2 3 此时连接不到3 3会丢失，所以反转前先把 3 建个索引存起来待回可直接连接到2
//关键：给链表建立 3 个索引（先用temp把后一个值存起来）
public class T24_ReverseList {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        //head 表示当前处理的节点  pre 表示前一个节点   after 表示后一个节点，存起来待会使用
        ListNode pre = null;
        ListNode after = null;

        //处理的节点不是最后一个，就一直处理
        while(head.next != null)
        {
            //反转前先把后一个节点存起来    反转    pre head 两个索引分别后移
            after = head.next;
            head.next = pre;
            pre = head;
            //可直接找到后一个节点，作用相当于交换时的 temp
            head = after;
        }
        //最后一个节点还要连接之前的节点
        head.next = pre;
        return head;
    }

    //递归解法
    public static ListNode ReverseList2(ListNode head)
    {
        if(head == null || head.next == null){
            return head;
        }

        //从第一位开始，第一位的pre为null
        return ReverseDigui(null,head);
    }

    public static ListNode ReverseDigui(ListNode pre, ListNode head)
    {
        if(head.next == null){
            head.next = pre;
            return head;
        }

        ListNode after = head.next;
        head.next = pre;
        return ReverseDigui(head,after);
    }


    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        System.out.println(ReverseList2(root).val);
    }

}
