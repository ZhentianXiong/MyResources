package LintCode;

import java.util.HashMap;
import java.util.Map;

//给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。
//输入 : s = "abccccdd",  输出 : 7,   一种可以构建出来的最长回文串方案是 "dccaccd"。
public class T1_627_LongestHuiwen {

    public int longestPalindrome(String s){
        if(s == null || s.length() == 0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                char key = s.charAt(i);
                int value = map.get(key);
                map.put(key,++value);
            }else{
                map.put(s.charAt(i),1);
            }
        }

        int len=0;
        boolean flag = false;
        for(Character c : map.keySet()){
            if(map.get(c)%2 == 0){
                len += map.get(c);
            }else{
                len += map.get(c)-1;
                flag = true;
            }
        }
        if(flag == false) {
            return len;
        }else{
            return len+1;
        }
    }

}
