package JZoffer;

//股票的最大利润：   股票的实时价格存进数组，什么时候买入卖出才能获得最大利润
//在扫描到第 i 个数时，只要记录前面所有数中的最小数即可知道目前的最大利润，  时间复杂度 O（N）
public class T63_MostValueOfTickets {

    public static void main(String[] args){
        int[] array = {9,11,8,5,7,12,16,14};

        int min = array[0];
        int diff = 0;
        for(int i =1;i<array.length;i++){
            diff = Math.max(diff,array[i]-min);
            min = Math.min(min,array[i]);
        }
        System.out.println(diff);
    }

}
