package JZoffer;

//归并排序
//任意长度 N 数组时间复杂度： O（NlogN）  但是所需额外空间与 N 成正比
//把数组一直二等分进行递归排序，每次排序后需要归并起来，递归的思想
//注意边界条件的判断
//归并时，先创建一个临时数组store用来存原始数据，然后才方便对原始数组做更改
//两个数组分别是low-middle,middle+1-high，用 i，j 做两个数组的索引，用 k 做原始数组的索引
public class T00_MergeSort {

    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        //排序前先建好一个长度等于原始数组长度的临时数组，避免递归中频繁开辟空间
        int[] store = new int[array.length];
        sort(array,0,array.length-1,store);
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }

    public static void sort(int[] array,int low,int high,int[] store)
    {
        if(low>=high)return;
        int middle = (low+high)/2;
        sort(array,low,middle,store);
        sort(array,middle+1,high,store);
        merge(array,low,middle,high,store);
    }

    public static void merge(int[] array,int low,int middle,int high,int[] store)
    {
        if(low>=high)return;
        for(int i=low;i<=high;i++)
        {
            store[i] = array[i];
        }

        int i = low;
        int j = middle+1;
        int k = low;

        //i，j都没有到达边界值，则谁小就存谁
        while(i<=middle && j<=high)
        {
            if(store[i]<=store[j])array[k++]=store[i++];
            else array[k++]=store[j++];
        }

        //j到达边界值，则只增加i中的值
        while(i<=middle)
        {
            array[k++]=store[i++];
        }

        //i已经到达了边界值
        while(j<=high)
        {
            array[k++]=store[j++];
        }

    }

}
