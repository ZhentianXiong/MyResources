package JZoffer;

//字符串中第一个只出现一次的字符：  在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
//直观思路： 总共只有52个字符，用一个数组记录52个字符出现的次数，另一个数组记录每个字符最近出现的位置     空间换时间
//更好的数据结构：   哈希表  记录每个字符出现过的次数    时间复杂度 O（N）
import java.util.HashMap;
import java.util.Map;

public class T50_FirstNotRepeatChar_1 {

    public static int firstNotRepeatCharInString(String str){
        if(str == null || str.length() == 0){
            return -1;
        }

        Map<Character,Integer> mapping = new HashMap<>();

        for(int i=0;i<str.length();i++){
            if(mapping.get(str.charAt(i)) == null){
                mapping.put(str.charAt(i),1);
            }else{
                mapping.put(str.charAt(i),mapping.get(str.charAt(i))+1);
            }
        }
        //characterMap.put(str.charAt(i), characterMap.getOrDefault(str.charAt(i), 0) + 1);

        for(int i=0;i<str.length();i++){
            if(mapping.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }


}
