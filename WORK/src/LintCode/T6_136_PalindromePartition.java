package LintCode;

import java.util.ArrayList;
import java.util.List;

public class T6_136_PalindromePartition {


    public static void main(String[] args){
        List<List<String>> res = partition("abaa");
        for(List<String> e : res){
            System.out.println(e);
        }
    }

    public static  List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        dfs(res,new ArrayList<String>(),s,0);
        return res;
    }

    private static  void dfs(List<List<String>> res, List<String> cur, String str, int index){
        if(index == str.length()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index; i < str.length();i++){
            String sub = str.substring(index,i+1);
            if(isHuiwen(sub)){
                cur.add(sub);
                dfs(res,cur,str,i+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static boolean isHuiwen(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }



}
