package JZoffer;

//字符串流中第一个不重复的字符：    请实现一个函数用来找出字符流中第一个只出现一次的字符。
//例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。没有输出'#'
import java.util.*;
public class T70_FirstNotRepeatInCharFlow {

    static boolean[] exist = new boolean[256];
    ArrayList<Character> res = new ArrayList<>();
    public void Insert(char ch)
    {
        if(exist[(int)ch] == true){
            for(int i = 0;i<res.size();i++){
                if(res.get(i) == ch)res.remove(i--);
            }
        }else{
            res.add(ch);
            exist[(int)ch] = true;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(res.size() == 0){
            return '#';
        }else{
            return res.get(0);
        }
    }
}