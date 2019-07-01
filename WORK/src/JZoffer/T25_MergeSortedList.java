package JZoffer;

//合并两个排序的链表:  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
//归并排序的思想，先排都没到最后的情况，再分别考虑两者中有一者到达末端的情况
public class T25_MergeSortedList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    //循环解法
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        //新建节点很关键，这样就可以有一个 next 用于初始化
        //新建一个节点，用于到时候直接返回，，另外新建一个一条链上的节点用于在尾部进行操作
        ListNode list = new ListNode(0);
        ListNode listTail = list;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                listTail.next = list1;
                //注意把尾指针一直处于末尾
                listTail = listTail.next;
                list1 = list1.next;
            } else {
                listTail.next = list2;
                listTail = listTail.next;
                list2 = list2.next;
            }
        }

        //某一条链上还剩下一个元素，还需要进行比较
        if (list1 == null) listTail.next = list2;
        else listTail.next = list1;

        return list.next;
    }

    //递归解法 简洁
    public static ListNode Merge2(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = Merge2(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge2(list1,list2.next);
            return list2;
        }

    }





}
