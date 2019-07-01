package JZoffer;

//字符流中第一个不重复的字符：        请实现一个函数用来找出字符流中第一个只出现一次的字符。
// 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。如果当前字符流没有存在出现一次的字符，返回#字符。
import java.util.HashMap;
import java.util.Map;

public class T50_FirstNotRepeatChar_2 {

    private StringBuilder res = new StringBuilder();
    Map<Character,Integer> mapping = new HashMap<>();

    public void Insert(char ch){
        res.append(ch);
        mapping.put(ch,mapping.getOrDefault(ch,0)+1);
    }

    public char firstAppearenceInStream(){
        for(char c : res.toString().toCharArray()){
            if(mapping.get(c) == 1){
                return c;
            }
        }
        return '#';
    }


}
