package JZoffer;

//数组中的逆序对：      在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
//题目保证输入的数组中没有的相同的数字。   数据范围：对于%50的数据,size<=10^4   对于%75的数据,size<=10^5      对于%100的数据,size<=2*10^5
//思路：  每一个数遍历比较其后面的数  O（N^2）时间复杂度太大
//考虑先比较两个相邻的数字，然后对相邻的子数组进行排序，然后在比较相邻的有序数组   ：  归并排序O（NlogN）
public class T51_NumberOfReversePair {

    static int num = 0;

    public static int reversePair(int[] array){
        if(array == null || array.length < 2){
            return 0;
        }
        digui(array,0,array.length-1);
        return num%1000000007;
    }

    //归并排序：   递归分解 - 归并
    public static void digui(int[] array, int start, int end){
        if(start >= end){
            return;
        }

        int mid = (start+end)>>1;
        digui(array,start,mid);
        digui(array,mid+1,end);
        merge(array,start,mid,end);
    }

    //归并
    public static void merge(int[] array, int start,int mid,int end){
        if(start >= end){
            return;
        }

        //节约额外的存储空间[start,mid,mid+1,end] - [0,mid-start,mid-start+1,end-start]
        int[] copy = new int[end-start+1];
        for(int i = 0;i<copy.length;i++){
            copy[i] = array[i+start];
        }

        //i,j 指向需要合并的两个子数组        k 指向合并后的数组
        int i=mid-start;
        int j=copy.length-1;
        int k=end;

        while(i >= 0 && j >= mid-start+1){
            if(copy[j] >= copy[i]){
                array[k--] = copy[j--];
            }else{
                array[k--] = copy[i--];
                //如果第一个子数组的数字大于第二个子数组的数字：  则逆序对的数目 = 第二个子数组中剩余数字的个数（因为有序）
                num = (num + j-mid+start)%1000000007;
            }
        }

        while(i >= 0){
            array[k--] = copy[i--];
        }

        while(j > mid-start){
            array[k--] = copy[j--];
        }

    }

    public static void main(String[] args){
        int[] a = {7,5,6,4};
        System.out.println(reversePair(a));
    }


}
