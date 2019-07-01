package algorithms4;

import java.util.Scanner;

//希尔排序：改进版的插入排序（当数组很大时，从插入点移到数组最前端很慢）
//将大的数组以间隔 h 划分为小的数组，先对小数组做插入排序，然后降低 h （三分法），再依次做插入排序，直到 h=1
//数组越大，优势越大，且不需要额外的内存空间
public class sortShell {
    public static void sort(Comparable[] a)
    {
        //从1开始，每次扩大三倍，一直到接近n/3-n
        int h=1;
        while(h<a.length/3) h=3*h+1;
        //逐渐缩小h， 直至为1
        while(h>=1)
        {
            System.out.println("h:"+h);
            show(a);
            //类似于从a[1]开始，这里从a[h]开始
            for(int i=h;i<a.length;i++)
            {
                // h 类似于 1
                for(int j=i;j>=h && compare(a[j-h],a[j]);j=j-h)
                {
                    exchange(a,j-h,j);
                }
            }
            h/=3;
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
