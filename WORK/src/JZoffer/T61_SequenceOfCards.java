package JZoffer;

import java.util.Arrays;

//扑克牌中的顺子：  扑克牌中随机抽5张牌，判断是不是一个顺子。2-10为本身，A为1，JQK为11，12，13，大小王可以当任意数
//先进性抽象建模   把大小王看作 0 ，然后统计0的数量与顺子之间相差元素的数量
public class T61_SequenceOfCards {

    public static boolean isSequence(int[] cards){
        if(cards == null || cards.length != 5){
            return false;
        }

        Arrays.sort(cards);
        int len0 = 0;
        int lenDistance = 0;
        //统计 0 大小王的数量
        for( int e : cards){
            if(e == 0)len0++;
        }

        //统计间隔数的数量  注意跳过 0 ，有对子出现时直接错误
        for(int i = len0+1;i<5;i++){
            if(cards[i] == cards[i-1])return false;
            //相差一是正常，差2才是少了一个数
            lenDistance += cards[i] - cards[i-1]-1;
        }

        //大于等于即可
        if(len0 >= lenDistance)return true;
        else return false;
    }


}
