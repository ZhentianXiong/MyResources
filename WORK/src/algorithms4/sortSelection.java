package algorithms4;

import java.util.*;

//选择排序：每次选择出最小的数依次放在第一、第二、...
//数组用索引来进行操作
//数据移动次数最少
public class sortSelection {

    public static void sort(Comparable[] a)
    {
        for(int i=0;i<a.length;i++)
        {
            int tempmin = i;
            for(int j=i+1;j<a.length;j++)
            {
                if(compare(a[tempmin],a[j])) tempmin=j;
            }
            exchange(a,i,tempmin);
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
