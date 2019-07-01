package JZoffer;

//把数字翻译成字符串：   0 翻译成 ”a”，1 翻译成 ”b”，……，11 翻译成 ”l”，……，25 翻译成 ”z”。
// 一个数字可能有多个翻译。例如 12258 有 5 种不同的翻译，它们分别是 ”bccfi”、”bwfi”、”bczi”、”mcfi”和”mzi”。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
//递归的思想从上至下分析，但是会有很多重复计算，用循环代码至下而上实现
public class T46_TranslateNumbersToStrings {

    public static int numberToStrings(String str){
        if(str == null || str.length()<2){
            return 1;
        }

        char[] chars = str.toCharArray();
        //利用数组存储子结果，避免重复计算
        int[] results = new int[str.length()];

        //初始化条件
        results[0] = 1;
        if(isLetter(chars[1],chars[0])) results[1] = 2;
        else results[1] = 1;

        //递归公式（从后往前）：  若两位连起来能满足条件：res[i] = res[i - 1] + res[i - 2]；否则：res[i] = res[i - 1]
        for(int i = 2;i<str.length();i++){
            if(isLetter(chars[i-1],chars[i]))results[i] = results[i-1] + results[i-2];
            else results[i] = results[i-1];
        }
        return results[str.length()-1];
    }

    public static boolean isLetter(char a,char b){
        int sum = (a-'0')*10 + (b-'0');
        if(sum >= 10 && sum <26){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        System.out.println(numberToStrings("12258"));
    }


}
