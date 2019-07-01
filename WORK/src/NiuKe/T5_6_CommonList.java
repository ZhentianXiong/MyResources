package NiuKe;

import java.util.ArrayList;

public class T5_6_CommonList {

    public class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int[] findCommonParts(ListNode heada, ListNode headb) {
        // write code here
        if(heada == null || headb == null){
            return null;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(heada != null && headb != null){
            if(heada.val == headb.val){
                res.add(heada.val);
                heada = heada.next;
                headb = headb.next;
            }else{
                if(heada.val < headb.val){
                    heada = heada.next;
                }else{
                    headb = headb.next;
                }
            }
        }

        int[] a = new int[res.size()];
        int i = 0;
        for(int e : res){
            a[i++] = e;
        }
        return a;
    }

}
