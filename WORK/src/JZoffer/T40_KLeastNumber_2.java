package JZoffer;

//找出最小的 K 个数  ---  解法2（适合海量数据的输入，且不修改数组）
//利用大根堆，时间复杂度为 O（nlogk），而且不会改变输入的数组
//假设题目要求从海量的数据中找出最小的 k 个数，由于内存的大小是有限的，有可能不能把这些海量的数据一次性全部载入内存，就用此方法。就是说它适合 n 很大并且 k 较小的问题。
//Java中的优先队列是基于堆实现的
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class T40_KLeastNumber_2 {

    public static ArrayList<Integer> k_leastNumber(int[] array, int k){
        ArrayList<Integer> result = new ArrayList<>();

        if(array == null || array.length == 0 || k < 1 || k > array.length){
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,Comparator.reverseOrder());

        for(int e : array){
            if(maxHeap.size() < k){
                maxHeap.add(e);
            }else{
                if(maxHeap.peek() > e){
                    maxHeap.poll();
                    maxHeap.add(e);
                }
            }
        }

        result.addAll(maxHeap);
        return result;
    }


}
