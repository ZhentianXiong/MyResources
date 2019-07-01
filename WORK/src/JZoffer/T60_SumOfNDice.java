package JZoffer;

//❌❌❌
//没做出来    有递归解法 和 循环解法（时间性能更好）
public class T60_SumOfNDice {

    public static void sumOfNDice(int n) {

        if (n < 1) {
            return ;
        }

        double sum = Math.pow(6, n);
        int[] times = new int[6 * n - n + 1];
        for(int e : times){
            e = 0;
        }
        probabilities(n,times);
        for(int i = n; i < 6*n;i++){
            System.out.print(i+" ");
            System.out.println(times[i-n]/sum);
        }
    }

    public static void probabilities(int num, int[] times){
        for(int i = num; i <= 6*num; i++){
            digui(num,num,i,times);
        }
    }

    public static void digui(int original, int current, int sum, int[] times){
        if(current == 1){
            times[sum - original]++;
        }else{
            for(int j = 1; j <= 6;j++){
                digui(original,current-1,sum+j,times);
            }
        }
    }


    public static void main(String[] args){
        sumOfNDice(5);
    }



}
