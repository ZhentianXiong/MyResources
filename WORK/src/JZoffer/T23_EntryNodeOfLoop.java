package JZoffer;

//链表中环的入口节点：   给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
//思路： 首先判断有没有环，有环还要找出环的大小  然后用两个指针遍历，一个先走环的大小步，相遇的节点即为入口节点
public class T23_EntryNodeOfLoop {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    //如果有环且知道环的大小    则用两个节点，一个先走 n 步，然后以相同的速度走，相遇的节点即为入口
    public static ListNode entryNodeOfLoop(ListNode head){
        ListNode exist = head;
        int n = existLoop(exist);
        if(n<0){
            return null;
        }else{
            ListNode second = head;
            for(int i=1;i<=n;i++){
                second = second.next;
            }

            while(second != head){
                head = head.next;
                second = second.next;
            }
            return head;
        }
    }

    //判断链表中是否存在环，并返回环中节点的数目   两个指针以不同速度遍历，相遇则有环  从相遇点走一圈再回到相遇点即为环的大小
    public static int existLoop(ListNode head){
        if(head == null || head.next == null){
            return -1;
        }

        ListNode fast = head.next;
        while(head.next != null && fast.next != null){
            if(fast == head){
                break;
            }else{
                head = head.next;
                fast = fast.next.next;
            }
        }

        int n = 0;
        if(fast.next == null || head.next == null){
            return -1;
        }else{
            while(head.next != fast){
                head = head.next;
                n++;
            }
            return ++n;
        }
    }


    public static void main(String[] args){

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = root.next.next;
        System.out.println(entryNodeOfLoop(root).val);
    }

}
