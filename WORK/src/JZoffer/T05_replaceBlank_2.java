package JZoffer;

//替换空格：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
//首先遍历一遍，统计空格数量，每一个在后面append两位（因为空格还有一位 %20有三位）
//然后生成两个指针，一个old指向扩展前最后一位,一个now指向扩展后最后一位，两个指针进行操作，old遇见一个空格，now填充三位
//小技巧：在合并两个数组时注意把数组从后往前遍历O（N）    如果从前往后的话：O（N^2）
public class T05_replaceBlank_2 {

    public static String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0) return str.toString();
        int old = str.length()-1;
        for(int i=0;i<=old;i++)
        {
            if(str.charAt(i) == ' ')str.append("  ");
        }
        int now = str.length()-1;
        for(int i=old;i>=0;i--)
        {
            char temp = str.charAt(i);
            if(temp != ' '){str.setCharAt(now,temp);now--;}
            else
                {
                    str.setCharAt(now,'0');
                    str.setCharAt(now-1,'2');
                    str.setCharAt(now-2,'%');
                    now-=3;}
        }
        return str.toString();
    }

    public static void main(String[] args)
    {
        StringBuffer str = new StringBuffer("sch sfb eif nn");
        System.out.println(replaceSpace(str));
    }

}
