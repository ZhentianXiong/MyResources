package JZoffer;

//跳台阶：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
//用数学归纳法可以证明 f=2^(n-1)
public class T10_jumpFloor2 {

    public int JumpFloorII(int target) {
        if(target<=0) return 0;
        //注意double转换为int的方式 （int）
        else return (int)Math.pow(2,target-1);
    }

}
