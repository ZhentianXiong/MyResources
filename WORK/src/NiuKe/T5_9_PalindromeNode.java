package NiuKe;

public class T5_9_PalindromeNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindrome(ListNode head) {
        // write code here
        if(head == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow);
        while(head != null && head2 != null){
            if(head.val != head2.val){
                return false;
            }else{
                if(head == slow || head2 == slow)return true;
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode next;
        ListNode pre = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            if(next == null){
                return head;
            }else {
                head = next;
            }
        }
        return head;
    }

}
