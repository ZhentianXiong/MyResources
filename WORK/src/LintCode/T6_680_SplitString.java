package LintCode;

import java.util.ArrayList;
import java.util.List;

public class T6_680_SplitString {

    public static List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),s,0);
        return res;
    }

    public static void dfs(List<List<String>> res, List<String> temp, String str, int cur){
        if(cur >= str.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(str.charAt(cur)+"");
        dfs(res,temp,str,cur+1);
        temp.remove(temp.size()-1);

        if(cur < str.length()-1) {
            temp.add(str.substring(cur, cur + 2));
            dfs(res, temp, str, cur + 2);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        System.out.println(splitString("012").get(2));
    }

}
