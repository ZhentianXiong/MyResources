package JZoffer;

//删除链表中的重复节点
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。
//思路很重要，代码严谨也很重要  两种实现方法：循环和递归
//先比较当前节点与后一个节点是否相等，不相等直接cur下一个； 相等，则判断其是否为最后的节点， 若不是尾节点，直接替换删除就好； 若是尾节点，还得重头找到尾节点前一个
public class T18_DeleteReapeatNode {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    //方法1： 循环方法
    public static ListNode deleteReapeatNode(ListNode root){
        //非法输入
        if(root == null || root.next == null){
            return root;
        }

        //复制一个根节点，不要直接操作根结点，根结点留着返回输出
        ListNode cur = root;
        // cur 表示当前操作节点，一直循环到最后一个
        while(cur.next != null){
            //相邻不相等，直接下一个
            if(cur.val != cur.next.val){
                cur = cur.next;
            }else{
                //一直找到不相等的哪一个  23334  cur在第一个3 nextdiff在第三个3
                ListNode nextDiff = cur;
                while(cur.val == nextDiff.next.val && nextDiff.next != null){
                    nextDiff = nextDiff.next;
                }

                //不为尾节点
                if(nextDiff.next != null){
                    cur.val = nextDiff.next.val;
                    cur.next = nextDiff.next.next;
                }else{
                    //尾节点：遍历
                    ListNode tempTail = root;
                    while(tempTail.next != cur){
                        tempTail = tempTail.next;
                    }
                    tempTail.next = null;
                    cur = tempTail;
                }
            }
        }
        return root;
    }

    //方法2：递归方法： 多个相等的一直减到只有两个连续相等的，然后成对的消除
    public static ListNode deleteReapeatNode2(ListNode root)
    {
        if(root == null || root.next == null){
            return root;
        }

        //当前值与下一个值相等
        if(root.val == root.next.val){
            //若为尾节点了，则把这两个删掉，直接返回null接到。next后
            if(root.next.next == null){
                return null;
            }

            //连续三个数相等，则删掉第一个，留两个相等的
            if(root.val == root.next.next.val){
                return deleteReapeatNode2(root.next);
            }

            //只有连续的两个相等，则成对删除两个
            return deleteReapeatNode2(root.next.next);
        }

        //当前值与下一个值不相等，则递归到下一个值
        root.next = deleteReapeatNode2(root.next);
        return root;
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
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);
        root.next.next.next.next.next = new ListNode(5);
        //root.next.next.next.next.next.next = new ListNode(5);

        printList(deleteReapeatNode(root));
        //printList(deleteReapeatNode2(root));
    }

}
