package algorithms4;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

//不知道文件大小，依次从文件中读取数据并放到一个数组中（queue,迭代）
//测试用例：1 2 3 4 6 5 stop
public class queue {

    public static void main(String[] args)
    {
        Queue<Integer> queue = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt()){
            queue.add(input.nextInt());
        }

        //迭代访问集合中的所有元素
            for (Integer e : queue) {
                System.out.print(e);
            }

            int n = queue.size();
            int[] show = new int[n];
            for (int i = 0; i < n; i++) {
                //.ppek()只返回不删除   .poll()返回并删除
                show[i] = queue.poll();
                System.out.println(show[i]);
            }
    }

}
