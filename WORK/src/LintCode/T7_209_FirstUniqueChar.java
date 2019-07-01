package LintCode;

import java.util.HashMap;
import java.util.Map;

public class T7_209_FirstUniqueChar {

    public char firstUniqChar(String str) {
        // Write your code here
        if(str == null || str.length() == 0){
            return '#';
        }

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char temp = str.charAt(i);
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }else{
                map.put(temp,map.get(temp)+1);
            }
        }

        //hashmap遍历方式
        for(char c : map.keySet()){
            if(map.get(c) == 1){
                return c;
            }
        }
        return '#';
    }

}
