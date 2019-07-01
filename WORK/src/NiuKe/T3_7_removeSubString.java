package NiuKe;

public class T3_7_removeSubString {

    public String stringTranslation(String A, int n, int len) {
        // write code here
        if(A == null || len >= A.length()){
            return A;
        }

        char[] a = A.toCharArray();
        reverse(a,0,len-1);
        reverse(a,len,A.length()-1);
        reverse(a,0,A.length()-1);
        return String.valueOf(a);
    }

    public void reverse(char[] a,int i,int j){
        while(i<j){
            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }

}
