package NiuKe;

public class T2_6_QuickSort {

    public int[] quickSort(int[] A, int n) {
        // write code here
        if(A.length != n){
            return null;
        }
        quick(A,0,A.length-1);
        return A;
    }

    public void quick(int[] a,int low,int high){
        if(low >= high)return;

        int temp = a[low];
        int templow = low;
        int temphigh = high;

        while(low < high){
            while(a[high] >= temp && high > low){
                high--;
            }
            a[low] = a[high];

            while(a[low] <= temp && low < high){
                low++;
            }
            a[high] = a[low];
        }

        a[low] = temp;
        quick(a,templow,low-1);
        quick(a,low+1,temphigh);
    }





    /*
     * 三向切分的快速排序：   low    lt    i     gt     hi
     * a[lo...lt-1]中的元素都小于v
     * a[gt+1....hi]中的元素都大于v
     * a[lt...i-1]中的元素都等于v
     * a[i...gt]中的元素都还未确定,通过下面处理
     * 1. a[i]小于v，将a[lt]和a[i]交换，将lt和i加1
     * 2. a[i]大于v，将a[gt]和a[i]交换，将gt减1
     * 3. a[i]等于v，将i加1
     * 这些操作都会保证数组元素不变且缩小gt-i的值，这样循环才会结束
     */
    private static void sort3way(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0) exch(a,lt++,i++);
            else if(cmp>0) exch(a,i,gt--);
            else i++;
        }//现在a[lo...lt-1] < v=a[lt...gt]<a[gt+1...hi]
        sort3way(a,lo,lt-1);
        sort3way(a,gt+1,hi);
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
