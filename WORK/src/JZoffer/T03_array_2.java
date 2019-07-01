package JZoffer;

import java.util.Scanner;

//不能修改数组找出重复的数字
/*一个长度为N+1的数组，其中所有的数字都在1-N之间，要求不修改数组找出其中一个重复的数字
创建一个长度为N+1的数组，放进去进行
时间：O（N），空间：O（N）因为额外创建数组了*/
public class T03_array_2 {

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
        findRepeat(b);
    }

    public static void findRepeat(int[] a)
    {
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            if(b[a[i]] == 0)b[a[i]]=a[i];
            else
            {
                System.out.println(a[i]);
                break;
            }
        }
    }



    public static void show(String[] a, int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            System.out.print(a[i]+" ");
        }
    }


}
