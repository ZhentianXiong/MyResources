package LintCode;

public class T3_228_MiddleNode {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode middleNode(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }

        ListNode twice = head;
        while(twice.next != null && twice.next.next != null){
            twice = twice.next.next;
            head = head.next;
        }
        return head;
    }

}
