package LintCode;

import java.util.LinkedList;
import java.util.Queue;

public class T7_642_MovingSlidesAverage {

    Queue<Integer> queue = new LinkedList<>();
    int size = 0;
    //加快求和速度
    double sum = 0;

    public T7_642_MovingSlidesAverage(int size) {
        // do intialization if necessary
        this.size = size;
    }


    public double next(int val) {
        // write your code here
        if(queue.size() < size){
            queue.offer(val);
            sum += val;
            return sum/queue.size();
        }else{
            sum -= queue.poll();
            queue.offer(val);
            sum += val;
            return sum/size;
        }
    }

}
