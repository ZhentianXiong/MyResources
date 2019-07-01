package NiuKe;

public class T3_6_ReverseSentence {

    public String reverseSentence(String A, int n) {
        // write code here
        if(A == null || A.length()<2){
            return A;
        }

        char[] a = A.toCharArray();
        reverse(a,0,a.length-1);
        int start = -1;
        int end = 0;
        while(start < a.length-1){
            while(end < a.length && a[end] != ' '){
                end++;
            }
            reverse(a,start+1,end-1);
            start = end;
            end++;
        }
        return String.valueOf(a);
    }

    public void reverse(char[] a,int i,int j){
        if(a == null || i>=j){
            return;
        }

        while(i<j){
            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }


}
