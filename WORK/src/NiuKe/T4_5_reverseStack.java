package NiuKe;

import java.util.Stack;

public class T4_5_reverseStack {

    public int[] reverseStack(int[] A, int n) {
        // write code here
        if(A == null){
            return null;
        }

        int[] res = new int[A.length];
        int i=0;
        Stack<Integer> stack = new Stack<>();
        for(int j = A.length-1;j>=0;j--){
            stack.push(A[j]);
        }

        reverse(stack);
        while(!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverse(stack);
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getLast(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getLast(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
           return result;
        }else{
            int last = getLast(stack);
            stack.push(result);
            return last;
        }
    }



}
