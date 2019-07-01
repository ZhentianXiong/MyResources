package NiuKe;

import java.util.Stack;

public class T4_2_minStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minstack.size() == 0){
            minstack.push(node);
        }else{
            if(minstack.peek() > node){
                minstack.push(node);
            }else{
                minstack.push(minstack.peek());
            }
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minstack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }else{
            return Integer.MAX_VALUE;
        }
    }

    public int min() {
        if (minstack.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return minstack.peek();
    }

}
