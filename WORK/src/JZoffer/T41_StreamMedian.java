package JZoffer;

//数据流中的中位数：   如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
//如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
//思路：用两个堆分别存大数和小数，这样就一直有两个指针指向最中间的两个数，且要保证两个堆中的数据量最多只能相差1
import java.util.Comparator;
import java.util.PriorityQueue;

public class T41_StreamMedian {

    //最小堆，存的都是大的树，指针指向的最小值为中间的数
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void Insert(Integer num) {
        if(maxHeap.isEmpty() || num > maxHeap.peek()){
            //先把数加入堆，若相差大于1了再进行调整
            minHeap.add(num);
            if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.add(minHeap.poll());
            }

        }else{
            maxHeap.add(num);
            if(maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public Double GetMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            if(maxHeap.size() > minHeap.size()){
                return (double)maxHeap.peek();
            }else{
                return (double)minHeap.peek();
            }
        }
    }



}
