package JZoffer;

//两个链表的第一个公共节点 ：     输入两个链表，找出它们的第一个公共结点。
//首先分析性质，若为公共节点，则其值和后续节点都一样，所以呈现 Y 结构，公共节点后面都一样
//链表为单向结构，若可以从后往前找到第一个不同的节点即可找到第一个公共节点      链表 + 栈
//解法二：  先遍历一遍两个链表，统计出长度，长的先走几步，然后两个可以同步到达尾节点，第一个相同的节点即为公共节点
import java.util.Stack;

public class T52_FirstCommonNodeInTwoLinkedlist {

    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    //解法1：   栈  时间复杂度: o(m+n)  空间复杂度：o(m+n)
    public static ListNode firstCommonNode(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            return null;
        }

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while(head1 != null){
            stack1.push(head1);
            head1 = head1.next;
        }

        while(head2 != null){
            stack2.push(head2);
            head2 = head2.next;
        }

        ListNode result = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek().equals(stack2.peek())){
                result = stack1.pop();
                stack2.pop();
            }else{
                return result;
            }
        }

        return result;

    }

    //解法2 ： 先统计长度差值  时间复杂度：o(m+n)    但是不需要额外的空间了
    public static ListNode firstCommonNode2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode temp1 = head1;
        ListNode temp2 = head2;
        int n1 = 0, n2 = 0;

        while (temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        if (n1 >= n2) {
            int n = n1 - n2;
            while (n > 0) {
                head1 = head1.next;
                n--;
            }
        } else {
            int n = n2 - n1;
            while (n > 0) {
                head2 = head2.next;
                n--;
            }
        }

        while (head1 != null) {
            if (head1.equals(head2)) {
                return head1;
            } else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return null;
    }





}
