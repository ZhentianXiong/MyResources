package JZoffer;

//丑数：   把只包含质因子2、3和5的数称作丑数（Ugly Number）。
//例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
//思路：  暴力破解：遍历每个数，一直除以2，3，5后商为1则为丑数，但是时间复杂度太大
//解法2：  以空间换时间    丑数必然是丑数*2，3，5得到的，所以用一个数组存储已有的丑数方便得到新的丑数，从而避免计算非丑数；
//为保证数组有序性，用三个指针分别指向当前扩大后可能超过最大丑数的数
public class T49_UglyNumber {

    public static int uglyNumber(int n){
        if(n<1){
            return 0;
        }

        //用 Arraylist 数据结构替换数组会更简单
        int[] result = new int[n];
        //第一个丑数为1
        result[0] = 1;
        int loc2 = 0, loc3 = 0, loc5 = 0, max = 0;
        while(max < n){
            while(result[loc2]*2 <= result[max]){
                loc2++;
            }

            while(result[loc3]*3 <= result[max]){
                loc3++;
            }

            while(result[loc5]*5 <= result[max]){
                loc5++;
            }

            //从已有丑数到下一个生成的丑数
            max++;

            if(max == n){
                break;
            }

            result[max] = Math.min(Math.min(result[loc2]*2,result[loc3]*3),result[loc5]*5);
        }
        return result[n-1];
    }

    public static void main(String[] args){
        System.out.println(uglyNumber(1500));
    }

}
