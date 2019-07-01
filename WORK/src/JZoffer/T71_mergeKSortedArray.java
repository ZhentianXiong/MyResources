package JZoffer;


/*将k个排序数组合并为一个大的排序数组。
        在 O(Nlogk) 的时间复杂度内完成：

        N是所有数组包含的整数个数。
        k 是数组的个数。*/
//解法1：小顶堆
//解法2：分治归并

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T71_mergeKSortedArray {

/*
    最简单的方法是创建一个N大小的数组，然后把所有数字拷贝进去，然后再进行时间复杂度为O(NlogN)排序算法，这样总体时间复杂度为O(NlogN)
    可以利用最小堆完成，时间复杂度是O(Nlogk)，具体过程如下：
    创建一个大小为N的数组保存最后的结果
    数组本身已经从小到大排好序，所以我们只需创建一个大小为k的最小堆，堆中初始元素为k个数组中的每个数组的第一个元素，每次从堆中取出最小元素（堆顶元素），并将其存入输出数组中，将堆顶元素所在行的下一元素加入堆，重新排列出堆顶元素，时间复杂度为logk，总共N个元素，所以总体时间复杂度是Nlogk*/


    class Element {
        public int row, col, val;
        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public class Solution {
        // 从小到大排序
        private Comparator<Element> ElementComparator = new Comparator<Element>() {
            public int compare(Element left, Element right) {
                return left.val - right.val;
            }
        };

        /**
         * @param arrays k sorted integer arrays
         * @return a sorted array
         */
        public int[] mergekSortedArrays(int[][] arrays) {
            if (arrays == null) {
                return new int[0];
            }

            int total_size = 0;
            // 默认由小到大顺序
            Queue<Element> Q = new PriorityQueue<Element>(
                    arrays.length, ElementComparator);

            // 初始化
            // 把每一行的第一个元素加入 PriorityQueue
            // 顺便统计元素总量
            for (int i = 0; i < arrays.length; i++) {
                // 当前行长度不为 0
                if (arrays[i].length > 0) {
                    Element elem = new Element(i, 0, arrays[i][0]);
                    Q.add(elem);
                    total_size += arrays[i].length;
                }
            }

            int[] result = new int[total_size];
            int index = 0;
            while (!Q.isEmpty()) {
                Element elem = Q.poll();
                result[index++] = elem.val;
                // 当前结点被 PriorityQueue 抛出来后，当前行的第二个结点加入 PriorityQueue
                if (elem.col + 1 < arrays[elem.row].length) {
                    elem.col += 1;
                    elem.val = arrays[elem.row][elem.col];
                    Q.add(elem);
                }
            }

            return result;
        }
    }


/*    分治法下的归并。我们知道合并两个排序数组直接使用merge即可，而合并k个可以将其看作两部分，左边归并后的结果与右边归并后的结果，然后再merge。

    递归出口是l==r，代表只有一个有序数组直接返回，l+1==r，代表刚好两个有序数组直接merge。*/

    public class Solution2 {
        /**
         * @param arrays: k sorted integer arrays
         * @return: a sorted array
         */
        public int[] mergekSortedArrays(int[][] arrays) {
            // write your code here
            if(arrays == null || arrays.length == 0)
                return null;

            return helper(arrays, 0, arrays.length-1);

        }

        private int[] helper(int[][] arrays, int l, int r){
            if(l == r)
                return arrays[l];
            if(l + 1 == r)
                return merge2Arrays(arrays[l], arrays[r]);

            int mid = l + (r-l)/2;
            int[] left = helper(arrays, l, mid);
            int[] right = helper(arrays, mid+1, r);

            return merge2Arrays(left, right);
        }

        private int[] merge2Arrays(int[] a, int[] b){
            int[] res = new int[a.length + b.length];

            int i=0, j=0;
            for(int k=0; k<res.length; k++){
                if(i >= a.length)
                    res[k] = b[j++];
                else if(j >= b.length)
                    res[k] = a[i++];
                else if(a[i] < b[j])
                    res[k] = a[i++];
                else
                    res[k] = b[j++];
            }

            return res;
        }
    }



}
