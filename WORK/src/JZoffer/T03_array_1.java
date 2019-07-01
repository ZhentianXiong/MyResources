package JZoffer;

import java.util.Scanner;

//找出数组中的重复数字
//在一个长度为 n 的数组里的所有数字都在 0 -（n-1）的范围内。
//时间复杂度：O（n一^2/2）,空间复杂度：O（1）因为没有额外分配内存
public class T03_array_1 {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] a = input.nextLine().split(" ");
        show(a,0,a.length);

        int repeatIndex = 0;
        for(int i=0;i<a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i].equals(a[j]))
                {
                    if(!exist(a,repeatIndex,a[i]))
                    {
                        a[repeatIndex++] = a[i];
                        break;
                    }
                }
            }
        }
        show(a,0,repeatIndex);

    }

    public static boolean exist(String[] a, int end,String b)
    {
        boolean flag = false;
        for(int i=0;i<end;i++)
        {
            if(a[i].equals(b))flag=true;break;
        }
        return flag;
    }

    public static void show(String[] a, int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            System.out.print(a[i]+" ");
        }
    }

}
