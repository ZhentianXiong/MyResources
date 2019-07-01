package algorithms4;

import java.util.ArrayList;
import java.util.Scanner;

//微众银行面试题，有限域，计算出一个数的所有不同构的有限域
public class webank_test {

    public static void main(String[] args) {

        int n = 37;

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i = 2;i<=n;i++){
            if(isPrime(i)){
                result.add(i);
                prime.add(i);
            }else{
                for(int j = 0;j<prime.size();j++){
                    if(isfield(i,prime.get(j))){
                        result.add(i);
                    }
                }
            }
        }

        System.out.println(result.toString());

    }

    public static boolean isfield(int n,int a){
        while(n >= a){
            if(n%a != 0){
                return false;
            }else{
                n = n/a;
            }
        }
        if(n == 1)return true;
        else{
            return false;
        }
    }



        public static boolean isPrime(int i){
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    flag=false;
                }
            }
            return flag;
        }

}


