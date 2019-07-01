package NiuKe;

public class T2_10_CountingSort {

    public int[] countingSort(int[] a, int n) {
        // write code here
        if(a == null || a.length<2){
            return a;
        }

        int min = a[0];
        int max = a[0];

        for(int i=1;i<a.length;i++){
            min = Math.min(a[i],min);
            max = Math.max(a[i],max);
        }

        int[] num = new int[max-min+1];
        for(int i=0;i<a.length;i++){
            num[a[i]-min]++;
        }

        int j=0;
        for(int i=0;i<num.length;i++){
            int temp = num[i];
            while(temp>0){
               a[j++] = i+min;
               temp--;
            }
        }
        return a;
    }

}
