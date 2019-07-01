package algorithms4;

//求多个数的最大公约数
public class liu2 {

    public static void main(String[] args)
    {
        int[] arr = new int[5];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = (int)(Math.random()*100);
            System.out.println(arr[i]);
        }
        for(int i=0;i<arr.length-1;i++)
        {
            arr[i+1] = gcd(arr[i],arr[i+1]);
        }
        System.out.println(arr[arr.length-1]);
    }

    public static int gcd(int a, int b)
    {
        if(b==0) return a;
        return a%b == 0 ? b : gcd(b,a%b);
    }

}
