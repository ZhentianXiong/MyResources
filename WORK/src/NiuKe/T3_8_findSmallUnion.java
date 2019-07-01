package NiuKe;

public class T3_8_findSmallUnion {

    public String findSmallest(String[] strs, int n) {
        // write code here
        if(strs == null || strs.length <= 1){
            return String.valueOf(strs);
        }

        for(int i = 0;i<strs.length-1;i++){
            for(int j = strs.length-1;j>i;j--){
                String a = strs[j] + strs[j-1];
                String b = strs[j-1] + strs[j];
                if(a.compareTo(b) < 0){
                    String temp = strs[j];
                    strs[j] = strs[j-1];
                    strs[j-1] = temp;
                }
            }
        }
        for(int i=1;i<strs.length;i++){
            strs[0] = strs[0]+strs[i];
        }
        return strs[0];
    }

}
