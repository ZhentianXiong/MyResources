package algorithms4;

import java.util.Scanner;

//插入排序：索引解法，注意a[0]
//从第二个数a[1]开始比较
//比较的数(到1)依次与前一个（到0）比较、交换即可
public class sortInsertion2 {
    public static void sort(Comparable[] a)
    {
        for(int i=1;i<a.length;i++)
        {
            //注意 k>0 要先进行判断
            for(int j=i;j>0 && compare(a[j-1],a[j]);j--)
            {
                exchange(a,j,(j-1));
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