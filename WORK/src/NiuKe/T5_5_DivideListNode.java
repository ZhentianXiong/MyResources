package NiuKe;

public class T5_5_DivideListNode {

    public class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

   public ListNode listDivide(ListNode head, int val) {
        // write code here

       if(head == null){
           return head;
       }

       ListNode small = null;
       ListNode smalltail = null;
       ListNode big = null;
       ListNode bigtail = null;
       ListNode next;

       while(head != null){
           next = head.next;
           head.next = null;

           if(head.val <= val){
               if(small == null){
                   small = head;
                   smalltail = head;
               }else{
                   smalltail.next = head;
                   smalltail = head;
               }
           }else{
               if(big == null){
                   big = head;
                   bigtail = head;
               }else{
                   bigtail.next = head;
                   bigtail = head;
               }
           }
           head = next;
       }

       if(small == null){
           return big;
       }else{
           smalltail.next = big;
           return small;
       }

    }

}
