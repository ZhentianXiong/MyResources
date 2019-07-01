package JZoffer;

//???????????????
//队列的最大值：    定义一个队列并实现函数Max得到队列里的最大值，要求函数 Max push pop 时间复杂度都是 O（1）
//双端队列：    滑动窗口大小为整个队列
import java.util.ArrayDeque;
import java.util.Deque;

public class T59_MaxQueueWithO1 {

    public static class QueueWithMax<T extends Comparable>{
    public static  class InternalData<M extends Comparable> {
        M number;
        int index;

        InternalData(M number, int index) {
            this.number = number;
            this.index = index;
        }
    }

        Deque<InternalData<T>> queueData = new ArrayDeque<>();
        Deque<InternalData<T>> queueMax = new ArrayDeque<>();
        int currentindex = 0;

        public T max() {
            if (queueMax.isEmpty()) {
                return null;
            }
            return queueMax.getFirst().number;
        }

        public void pushBack(T value) {
            while (!queueMax.isEmpty() && value.compareTo(queueMax.getLast().number) >= 0) {
                queueMax.removeLast();
            }

            InternalData<T> addData = new InternalData<>(value, currentindex);
            queueMax.addLast(addData);
            queueData.addLast(addData);
            currentindex++;
        }

        public T popFront() {
            if (queueData.isEmpty()) {
                return null;
            }
            InternalData<T> delData = queueData.removeFirst();
            if (delData.index == queueMax.getFirst().index) {
                queueMax.removeFirst();
            }
            return delData.number;
        }
    }

    public static void main(String[] args) {
    QueueWithMax<Integer> queue = new QueueWithMax<>();
        queue.pushBack(3);
        System.out.println(queue.max());
        queue.pushBack(5);
        System.out.println(queue.max());
        queue.pushBack(1);
        System.out.println(queue.max());
        System.out.println("开始出队后，调用max");
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());


}



}
