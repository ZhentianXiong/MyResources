package NiuKe;

public class T5_8_ClearListNode {

    public class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode clear(ListNode head, int val) {
        // write code here
        if(head == null){
            return head;
        }

        ListNode res = null;
        ListNode tail = null;
        ListNode next;

        while(head != null){
            next = head.next;
            if(head.val != val){
                if(res == null){
                    res = head;
                    tail = head;
                }else{
                    tail.next = head;
                    tail = tail.next;
                }
            }
            head = next;
        }
        return res;
    }

}
