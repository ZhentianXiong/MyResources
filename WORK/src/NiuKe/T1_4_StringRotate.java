package NiuKe;

public class T1_4_StringRotate {

    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena != lenb || A.length() != lena || B.length() != lenb){
            return false;
        }

        String a = A+A;
        return a.contains(B);

    }

}
