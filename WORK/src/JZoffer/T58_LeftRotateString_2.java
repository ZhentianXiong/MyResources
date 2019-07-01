package JZoffer;

//左旋转字符串：     例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
//解法2：  两次翻转   YX = （（X^T)（Y^T)）^T
public class T58_LeftRotateString_2 {

    public static String leftRotateString(String str,int index){
        if(str == null || str.length() < index || index <0)
        {
            return "";
        }

        String str1 = str.substring(0,index);
        String str2 = str.substring(index,str.length());
        return str2.concat(str1);
    }

    //解法2
    public static String leftRotateString2(String str,int index){
        if(str == null || str.length() < index || index <0)
        {
            return "";
        }

        char[] array = str.toCharArray();
        reverse(array,0,index-1);
        reverse(array,index,array.length-1);
        reverse(array,0,array.length-1);
        return new String(array);
    }

    public static void reverse(char[] array, int i, int j){
        while(i<j){
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
    }


}
