package JZoffer;

import java.util.Scanner;

//找出数组中的重复数字
//在一个长度为 n 的数组里的所有数字都在 0 -（n-1）的范围内。
//时间复杂度：O（n）因为每个数字最多只要交换两次就能找到属于自己的位置,空间复杂度：O（1）因为没有额外分配内存
//依次遍历数组（0 -（n-1））
/*第i个数与a【i】是否相等，是则下一个
否则，比较a【i】=m与a【m】是否相等
是，则找到一个重复的；否则就交换a【i】与a【m】，然后loop；*/
public class T03_array_1_2 {

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
        duplicate(b);
    }

    public static void duplicate(int[] a)
    {
        //showint(a,0,a.length);
        for(int i=0;i<a.length;i++)
        {
            while(i != a[i])
            {
                if(a[i] == a[a[i]])
                {
                    System.out.println(a[i]);
                    break;
                }else
                {
                    exchange(a,i,a[i]);
                    //showint(a,0,a.length);
                }
            }

        }
    }

    public static void exchange(int[] a, int i,int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(String[] a, int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            System.out.print(a[i]+" ");
        }
    }

    public static void showint(int[] a, int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            System.out.print(a[i]+" ");
        }
    }

}
