package LintCode;

//中心扩展法，以每个节点开始向左右进行扩展，但是要注意有两种回文数  abba  abcba
//还有 动态规划法 和 两侧比较法
public class T1_200_LongestHuiwenzi {
    public static String longestPalindrome(String s) {
        String res = s.substring(0,1);
        if(s == null || res.length() == 0){
            return "";
        }

        for(int i=0;i<s.length();i++){
            if(i == s.length()-1 || s.charAt(i) != s.charAt(i+1)){
                String temp = huiwen(i,i,s);
                if(temp.length() > res.length()){
                    res = temp;
                }
            }else{
                String temp1 = huiwen(i,i,s);
                String temp2 = huiwen(i,i+1,s);
                if(temp1.length() > res.length()){res = temp1;}
                if(temp2.length() > res.length()){res = temp2;}
            }
        }

        return res;
    }

    public static String huiwen(int i,int j, String str){
        while(i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
        }
        return str.substring(++i,j);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("abcbad"));
    }
}
