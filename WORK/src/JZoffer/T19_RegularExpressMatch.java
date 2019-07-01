package JZoffer;

//正则表达式匹配
//请实现一个函数用来匹配包括.和*的正则表达式。模式中的字符.表示任意一个字符，而*表示它前面的字符可以出现任意次（包含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串aaa与模式a.a和ab*ac*a匹配，但是与aa.a和ab*a均不匹配。
//思路：判断索引的下一位是否为 * ，否则很好处理，是则用回溯的思想，有一种是可行的即可
public class T19_RegularExpressMatch {

    public static boolean match(char[] str, char[] pattern) {
        //无效输入
        if(str == null && pattern == null){
            return true;
        }

        //str=null pattern=a*   也正确
        if(pattern == null){
            return false;
        }

        // i：字符串上的索引  j：正则表达式上的索引
        return match(str,0,str.length,pattern,0,pattern.length);
    }

    public static boolean match(char[] str, int i, int strlen, char[] pattern, int j, int palen){
        //正确执行到了结束，返回true
        if(i >= strlen && j >= palen){
            return true;
        }

        //？若删去， a   .*   会出现数组越界
        if(i != strlen && j == palen){
            return false;
        }

        //注意防止数组越界，因为有取操作 j+1
        //当后一位是 * 时
        if(j+1<palen && pattern[j+1] == '*')
        {
            if(i<strlen && (str[i] == pattern[j] || pattern[j] == '.'))
            {
                //三种情况有一种正确即可返回true
                return match(str,i,strlen,pattern,j+2,palen)
                        || match(str,i+1,strlen,pattern,j,palen)
                        || match(str,i+1,strlen,pattern,j+2,palen);
            }else {
                return match(str, i, strlen, pattern, j + 2, palen);
            }
        }else
        {
            if(i<strlen && (str[i] == pattern[j] || pattern[j] == '.')){
                return match(str,i+1,strlen,pattern,j+1,palen);
            }else{
                return false;
            }
        }
    }

    public static  void main(String[] args){
        char[] str = {'a','a','a'};
        char[] pattern = "aa.a".toCharArray();
        System.out.println(match(str,pattern));
    }
}
