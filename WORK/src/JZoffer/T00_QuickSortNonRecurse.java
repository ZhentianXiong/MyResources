package JZoffer;

import java.util.LinkedList;
import java.util.Stack;

public class T00_QuickSortNonRecurse {

    public static void main(String[] args){
        int[] a = {3,6,0,8,2,7,1,4,9,3,7};
        quickSort_nonRecurrent(a,0,a.length-1);
        for(int e : a){
            System.out.print(e);
        }
    }

    public static void quickSort_nonRecurrent(int[] a, int start, int end){
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        stack.push(start);
        while(!stack.isEmpty()){
            int i = stack.pop();
            int j = stack.pop();
            int pivot = Partition(a,i,j);

            if(pivot - 1 > i){
                stack.push(pivot - 1);
                stack.push(i);
            }

            if(pivot + 1 < j){
                stack.push(j);
                stack.push(pivot + 1);
            }
        }
    }

    public static int Partition(int[] a,int start,int end){
        int temp = a[start];
        while(start < end){
            while(start < end && a[end] >= temp){
                end--;
            }
            a[start] = a[end];
            while(start < end && a[start] <= temp){
                start++;
            }
            a[end] = a[start];
        }
        a[start] = temp;
        return start;
    }



}
