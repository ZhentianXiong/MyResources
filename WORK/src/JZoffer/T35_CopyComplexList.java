package JZoffer;

//复杂链表的复制：  输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
//若先从头到尾复制节点，再每个节点从头到尾找特殊指针，则 O（N^2） 若加哈希表存储特殊指针位置会有额外的空间开销
//1、将每个节点复制一份插入到原节点后面    2、根据原节点的任意指针指向可快速找到复制节点的指针指向     3、调整复制节点的连接方式，输出
public class T35_CopyComplexList {

    public static class RandomListNode{
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode head){

        if(head == null){
            return head;
        }

        RandomListNode move = head;

        //1、复制所有的节点并连在原始节点后面
        while(move != null){
            RandomListNode copy = new RandomListNode(move.label);
            copy.next = move.next;
            move.next = copy;
            move = move.next.next;
        }

        //根据原节点任意指针快速找到复制节点任意指针的指向
        move = head;
        while(move != null){
            if(move.random == null){
                move = move.next.next;
            }else{
                move.next.random = move.random.next;
                move = move.next.next;
            }
        }

        //调整复制节点的指向。输出
        move = head;
        RandomListNode result = head.next;
        while(move.next != null){
            RandomListNode clone = move.next;
            if(clone.next != null){
                clone.next = clone.next.next;
                move = clone.next;
            }else{
                move = clone;
            }
        }

        return result;

    }

}
