package NiuKe;

import java.util.Stack;

public class T4_4_TwoStackToQueue {

    public int[] twoStack(int[] ope, int n) {
        // write code here
        if(ope == null){
            return null;
        }

        int size = 0;
        for(int e : ope){
            if(e == 0){
                size++;
            }
        }
        int[] res = new int[size];
        int j = 0;

        Stack<Integer> stackin = new Stack<>();
        Stack<Integer> stackout = new Stack<>();

        for(int i : ope){
            if(i > 0){
                stackin.push(i);
            }else{
                if(!stackout.isEmpty()){
                    res[j++] = stackout.pop();
                }else{
                    while(!stackin.isEmpty()){
                        stackout.push(stackin.pop());
                    }
                    res[j++] = stackout.pop();
                }
            }
        }
        return res;
    }

}
