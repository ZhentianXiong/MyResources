package JZoffer;

//调整数组顺序使奇数位于偶数前面
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
//思路1：快速排序的思想，用两个指针来进行比较交换
//思路2：另外开辟一个数组，空间换时间
//思路3：冒泡排序的思想，前偶后奇就交换
public class T21_ReorderArray {

    //奇数与奇数，偶数与偶数之间的相对顺序会改变  从最前最后往中间靠拢
    public static void reOrderArray(int[] array){

        if(array.length <= 1 || array == null){
            return ;
        }

        int i = 0;
        int j = array.length-1;

        while(i<j)
        {
            while(i<j && (array[i] & 1) == 1){
                i++;
            }

            while(i<j && (array[j] & 1) == 0){
                j--;
            }

            exchange(array,i,j);
        }

    }

    //保证奇数与奇数，偶数与偶数之间的相对顺序不变  两个指针都从前开始
    public static void reOrderArray2(int[] array){
        if(array == null || array.length <= 1){
            return;
        }

        int i = 0;
        int j = 0;

        while(i<array.length && j<array.length)
        {
            while(i<array.length && (array[i] & 1)==1)
            {
                i++;
            }

            j=i+1;
            while(j<array.length && (array[j] & 1)==0)
            {
                j++;
            }

            if(j<array.length) {
                houyi(array, i, j);
            }else{
                break;
            }
            //不能加这一句，加了就只能排相邻的了，无法排整体的 3 6 4 7 8 3 2 1 9 0 10
            //i=j+1;
        }

    }

    public static void houyi(int[] array,int i,int j){
        int temp = array[j];
        for(int k = j-1;k>=i;k--){
            array[k+1] = array[k];
        }
        array[i] = temp;
    }


    public static void exchange(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        int[] array = {6,4,3,8,7,2,3,1,0,10,9};
        reOrderArray2(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

}
