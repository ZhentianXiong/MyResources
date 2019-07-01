package JZoffer;

//最长不含重复字符的子字符串 ：    请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。假设字符串中只包含从 a 到 z的字符。
//动态规划：   len[i] 表示以第 I 个字符结尾时不包含重复字符的子字符串的最大长度，其取决于与 a[i] 相同元素的位置
//若两相同字符间隔 d>len[i-1] 说明已经不重要了，len[i] = len[i-1]+1;   若d<=len[i-1] 则重复字符在考虑情况内，直接删除前一个重复字符  len[i]=d
public class T48_longestSubstringWithoutDuplication {

    public static void main(String[] args){
        String str = "abacbda";
        System.out.println(longSubstring2(str));
        System.out.println(longestSubstring(str));
    }

    public static int longestSubstring(String str){
        if(str == null || str.length() == 0){
            return 0;
        }

        char[] chars = str.toCharArray();
        //辅助数组：存储第 i 位时的最长子串长度
        int[] len = new int[chars.length];
        len[0] = 1;

        //递归公式的循环实现
        for(int i=1;i<chars.length;i++){
            int d = duplication(chars,chars[i],i-1,len[i-1]);
            if(d < 0) len[i] = len[i-1]+1;
            else len[i] = d;
        }

        int max = 0;
        for(int e : len){
            max = Math.max(max,e);
        }
        return max;
    }

    //判断当前最长子串中是否有重复字符，有则返回长度，没有返回 -1
    public static int duplication(char[] chars,char letter, int i,int len){
        int d=1;
        for(int j = i;j>i-len;j--) {
            if (chars[j] == letter) return d;
            d++;
        }
        return -1;
    }


    //解法2： 增加一个字母表数组记录每个字母最近一次出现的坐标，减少查询
    public static int longSubstring2(String str){
        if(str == null || str.length()<1){
            return 0;
        }

        char[] chars = str.toCharArray();
        int[] results = new int[chars.length];
        //记录字母最近出现位置
        int[] location = new int[26];

        for(int e : location){
            location[e] = -1;
        }

        results[0] = 1;
        location[chars[0] - 'a'] = 0;
        for(int i = 1;i<chars.length;i++){
            if(location[chars[i] - 'a'] == -1 || i-location[chars[i]-'a'] > results[i-1]){
                results[i] = results[i-1]+1;
            }
            else{
                    results[i] = i - location[chars[i]-'a'];
            }
            location[chars[i]-'a'] = i;
        }

        int max = 0;
        for(int e : results){
           max = Math.max(max,e);
        }
        return max;
    }





}
