package algorithms4;

import java.util.Scanner;

//插入排序：左边的元素全部已经排好序，下一个元素依次插入到左边的序列中
//考虑到两个为0的时候
//减少元素交换，只做右移，减少对数组的访问次数
public class sortInsertion {
    public static void sort(Comparable[] a)
    {
        //表示需要插入的数，a[0]不用，直接从下一个开始
        for(int i=1; i<a.length; i++)
        {
            Comparable temp = a[i];
            for(int j=i-1; j>=0; j--)
            {
                //如果所插的数为最小，则要直接把a[0]进行赋值
                if(compare(a[j],temp)){
                    if(j != 0) a[j+1] = a[j];
                    else {a[j+1] = a[j];a[j]=temp;}
                }
                else {a[j+1] = temp;break;}
            }

        }
    }

    //a>b true
    public static boolean compare(Comparable a, Comparable b)
    {
        return a.compareTo(b)>0;
    }

    public static void exchange(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a)
    {
        for (Comparable e:a)
        {
            System.out.print(e+" ");
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] array = input.nextLine().split(" ");
        sort(array);
        show(array);
    }

}