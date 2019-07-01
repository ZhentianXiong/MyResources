package LintCode;

//对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
public class T1_13_SearchString {

    public static int searchString(String source, String target){
        if(source == null || target == null || target.length() > source.length()){
            return -1;
        }

        if(target.length() == 0){
            return 0;
        }

        char[] charsource = source.toCharArray();

        for(int i = 0;i<=(source.length() - target.length());i++){
            if(target.equals(source.substring(i,i+target.length()))){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(searchString("abcde","a"));
    }


}
