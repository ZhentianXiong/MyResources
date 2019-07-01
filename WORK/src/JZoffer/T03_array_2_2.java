package JZoffer;

import java.util.Scanner;

//不能修改数组找出重复的数字
/*一个长度为N+1的数组，其中所有的数字都在1-N之间，要求不修改数组找出其中一个重复的数字
类似二分查找，每次取中间数，统计两边的数字数目，然后有重复的一边在进行二分统计
时间：O（NlogN）因为二分log N，且每次统计都要遍历一遍N统计数目，空间：O（1）*/
public class T03_array_2_2 {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] a = input.nextLine().split(" ");
        show(a, 0, a.length);
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            b[i] = Integer.parseInt(a[i]);
        }
        findRepeat(b,1,b.length-1);
    }

    public static void findRepeat(int[] a, int low, int high)
    {
        int middle = low+(high-low)/2;
        System.out.println(middle);
        int countLow=0;
        int countMiddle=0;
        int countHigh=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i] == middle)countMiddle++;
            else if(a[i]>middle)countHigh++;
            else countLow++;
        }
        if(countMiddle>1)System.out.print(middle);
        else if(countLow>(middle-low)) findRepeat(a,low,middle);
        else findRepeat(a,middle,high);
    }


    public static void show(String[] a, int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            System.out.print(a[i]+" ");
        }
    }

}
