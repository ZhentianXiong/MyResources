package NiuKe;

import java.util.HashMap;
import java.util.Map;

public class T3_3_WordTransfer {

    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        if(A == null || B == null || lena != lenb){
            return false;
        }

        Map<Character,Integer> mapa = new HashMap<>();
        Map<Character,Integer> mapb = new HashMap<>();

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        for(int i = 0;i<A.length();i++){
            mapa.put(a[i],(mapa.getOrDefault(a[i],0)+1));
            mapb.put(b[i],(mapb.getOrDefault(b[i],0)+1));
        }

        for(Character key : mapa.keySet()){
            if(!mapb.containsKey(key) || mapa.get(key) != mapb.get(key)){
                return false;
            }
        }
        return true;
    }




    public boolean chkTransform2(String A, int lena, String B, int lenb) {
        // write code here
        if(A == null || B == null || A.length() != B.length()){
            return false;
        }

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int[] map = new int[256];
        for(int i=0;i<a.length;i++){
            map[a[i]]++;
        }

        for(int i=0;i<b.length;i++){
            if(map[b[i]]-- == 0){
                return false;
            }
        }
        return true;
    }

}
