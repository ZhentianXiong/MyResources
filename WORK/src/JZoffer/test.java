package JZoffer;

public class test {
    public static void main(String[] args){
        int a = -3;
        double res = 0;
        for(int i = 0;i<32;i++){
            res += (a & 1)*Math.pow(2,i);
            a = a >> 1;
        }
        char b = 'a';
        System.out.println(b-'A');
    }
}
