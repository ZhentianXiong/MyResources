package JZoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//滑动窗口的最大值：    给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
//例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
//思路1：  最简单遍历一遍，时间复杂度 O（Nk）因为每一个数需要在 O（k）内找出滑动窗口内的最大值；
//思路2：  用两个栈可以在 O（1） 内找出最大值，且队列可以用两个栈实现，但是太复杂；
//思路3：  用  双端队列  实现： 队列头永远保存滑动窗口内的最大值
public class T59_SlidingWindows_1 {

    public static ArrayList<Integer> maxInWindows(int[] array,int size){
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || size<1 || size > array.length){
            return result;
        }

        //Deque：双端队列，first，last都可以操作
        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0; i < array.length; i++){
            //新加入一个元素，若大于队列中已有元素，则一次移除队列尾的元素
            while(!queue.isEmpty() && array[i] > array[queue.getLast()]){
                queue.pollLast();
            }

            //新加入一个元素，若小于队列中已有元素，但是数量已经超过滑动窗口大小，则移除队列头的元素
            while(!queue.isEmpty() && (i-queue.getFirst()+1)>size){
                queue.pollFirst();
            }

            queue.add(i);
            //比滑动窗口大小大后，每次都去队列头元素作为结果
            if(!queue.isEmpty() && (i >= size-1)){
                result.add(array[queue.getFirst()]);
            }
        }

        return result;
    }



}
