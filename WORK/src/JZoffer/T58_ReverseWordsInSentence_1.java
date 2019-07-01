package JZoffer;

//翻转字符串：  “I am a student.” 翻转为： “student. a am I”
public class T58_ReverseWordsInSentence_1 {

    public static String reverseWordsInSentence(String str){
        //防止" "返回""，应该返回" "
        if(str == null || str.length() < 2 || str.trim().equals("")){
            return str;
        }

        String[] chars = str.split(" ");
        //注意使用这种交换方法，简单不会出错
        int low = 0;
        int high = chars.length-1;
        while(low < high){
            String temp = chars[low];
            chars[low++] = chars[high];
            chars[high--] = temp;
        }

        //用" "连接数组各元素并生成字符串
        return String.join(" ",chars);
    }

}
