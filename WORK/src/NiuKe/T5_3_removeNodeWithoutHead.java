package NiuKe;

public class T5_3_removeNodeWithoutHead {

    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode removeNode(ListNode pNode, int delVal) {
        // write code here
        if(pNode == null || pNode.val != delVal){
            return pNode;
        }

        ListNode next = pNode.next;
        if(next == null){
            return null;
        }else{
            pNode.val = next.val;
            pNode.next = next.next;
            return pNode;
        }

    }

}
