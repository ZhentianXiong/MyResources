package JZoffer;

//在 O（1） 时间内删除链表节点
//如果顺序扫描删除，则时间复杂度必定 O（N） 如果要找到所删节点的前一个节点，则必须扫描，可以考虑使用所删节点的后一个节点
//将后一个节点的值拷贝到所删节点，然后删除后一个节点即可。 如果所删是头节点？尾节点（必须扫描）？链表只有一个节点？
//总时间复杂度： [(n-1)*O(1)+1*O(n)]/n = O(1)  如果所删节点不在链表中，则必定是O（N）
public class T18_DeleteNodeIN1 {

    public static class ListNode
    {
        int val ;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
        }
    }

    public static ListNode deleteNodeIN1Time(ListNode head,ListNode delete)
    {
        //输入为空，直接返回
        if(head == null || delete == null){
            return head;
        }

        //所删节点为尾指针
        if(delete.next == null){
            //且只有一个节点，直接删除
            if(head == delete){
                head = null;
            }else{
                //尾指针，从前往后遍历
                ListNode ope = head;
                while(ope.next != delete && ope.next != null){
                    ope = ope.next;
                }
                ope.next = null;
            }
        }else{
            //中间指针或头指针：代替删除后一个指针进行间接删除
            delete.val = delete.next.val;
            delete.next = delete.next.next;
        }
        return head;
    }

    public static void printList(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode outside = new ListNode(6);

        //删除尾指针-中间指针-头指针-不存在的节点
        printList(deleteNodeIN1Time(root,root.next.next.next.next));
        printList(deleteNodeIN1Time(root,root.next.next));
        printList(deleteNodeIN1Time(root,root));
        printList(deleteNodeIN1Time(root,outside));
    }

}
