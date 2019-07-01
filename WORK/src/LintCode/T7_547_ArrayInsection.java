package LintCode;

import java.util.Arrays;

public class T7_547_ArrayInsection {

    public int[] intersection(int[] num1, int[] num2) {
        // write your code here
        if(num1 == null || num2 == null || num1.length == 0 || num2.length == 0){
            return new int[0];
        }

        int[] res = new int[Math.max(num1.length,num2.length)];
        Arrays.sort(num1);
        Arrays.sort(num2);
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while(index1 < num1.length && index2 < num2.length){
            if(num1[index1] == num2[index2]){
                if(index == 0 || num1[index1] != res[index-1]){
                    res[index++] = num1[index1];
                }
                index1++;
                index2++;
            }else{
                if(num1[index1] > num2[index2]){
                    index2++;
                }else{
                    index1++;
                }
            }
        }

        int[] result = new int[index];
        for(int i=0;i<index;i++){
            result[i] = res[i];
        }
        return result;
    }

}
