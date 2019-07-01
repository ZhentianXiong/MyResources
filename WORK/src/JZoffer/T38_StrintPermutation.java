package JZoffer;

//?????????
//字符串的排列：      输入一个字符串,按字典序打印出该字符串中字符的所有排列。
//例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。  输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
//思路：  每次考虑一位，考虑此位可否与后面的字符交换，可以则交换后   递归   后面的串
//扩展： 如果求所有可能的组合，即 ab ba 只能有一个且可以有 a b c这种，
//八皇后问题（不同行，不同列，不同对角线）
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class T38_StrintPermutation {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();

        if(str == null || str.length()<1){
            return result;
        }

        char[] strchar = str.toCharArray();
        digui(strchar,0,result);
        //对集合进行排序
        Collections.sort(result);
        return result;
    }

    //
    public static void digui(char[] str, int index, ArrayList<String> result){
        //递归到数组最后一位时，直接转换成string加入最终结果集合
        if(index == str.length-1){
            result.add(new String(str));
            return;
        }

        //无序集合
        Set<Character> set = new HashSet<>();

        for(int i = index; i<str.length;i++){
            //如果该字符从未出现过，则交换后递归剩下的
            if(!set.contains(str[i])){
                set.add(str[i]);
                swap(str,index,i);
                digui(str,index+1,result);
                //递归完后恢复原数组，继续考虑下一个字符
                swap(str,index,i);
            }
        }

    }

    public static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
