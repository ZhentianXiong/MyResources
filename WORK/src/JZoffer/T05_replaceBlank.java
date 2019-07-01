package JZoffer;

//替换空格：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
//时间：O（N） 空间：O（1）
//网络编程中：空格#等特殊字符会导致服务器无法正常获得参数，将其转换为%+两位十六进制的表示，所以为 %20
public class T05_replaceBlank {

    public static String replaceSpace(StringBuffer str) {
        //判断输入是否合法
        if(str.equals(null) || str.length()==0) return str.toString();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == ' ')
                str.replace(i,i+1,"%20");
        }
        return str.toString();
    }

    public static void main(String[] args)
    {
        StringBuffer str = new StringBuffer("sch sfb eif nn");
        System.out.println(replaceSpace(str));

    }

}
