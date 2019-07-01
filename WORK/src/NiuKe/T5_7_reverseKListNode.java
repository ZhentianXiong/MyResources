package NiuKe;

import java.util.Stack;

public class T5_7_reverseKListNode {

    public class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode inverse(ListNode head, int k) {
        // write code here
        if(head == null || k<2){
            return head;
        }

        ListNode res = null;
        ListNode restail = null;
        ListNode next = null;

        Stack<ListNode> stack = new Stack<>();

        int i = 0;
        while(head != null){
            i++;
            next = head.next;
            stack.push(head);

            if(i == k){
                while(!stack.isEmpty()){
                    if(res == null){
                        res = stack.pop();
                        restail = res;
                    }else{
                        restail.next = stack.pop();
                        restail = restail.next;
                    }
                }
                i = 0;
            }

            head = next;
        }

        ListNode order = null;
        ListNode temp = null;
        while(!stack.isEmpty()){
            if(order == null){
                order = stack.pop();
            }else{
                temp = stack.pop();
                temp.next = order;
                order = temp;
            }
        }

        if(restail == null){
            return order;
        }else{
            restail.next = order;
            return res;
        }

    }

}
