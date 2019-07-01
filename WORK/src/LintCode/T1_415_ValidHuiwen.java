package LintCode;

public class T1_415_ValidHuiwen {

    public boolean isPalindrome(String s){
        if(s == null){
            return false;
        }

        if(s.length() == 0){
            return true;
        }

        int i = 0;
        int j = s.length()-1;
        while(i < j){
            while(i<j && !isletter(s.charAt(i))){i++;}
            while(j>i && !isletter(s.charAt(j))){j--;}
            if(s.charAt(i) == s.charAt(j) || Math.abs(s.charAt(i) - s.charAt(j)) == 32){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isletter(char c){
        if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
            return true;
        }else{
            return false;
        }
    }

}
