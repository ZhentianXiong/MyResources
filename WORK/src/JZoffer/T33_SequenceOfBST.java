package JZoffer;

//二叉搜索树的后序遍历序列：  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
//思路： 最后一个为根结点，只要一部分小于根结点，后面的全部大于根结点，然后递归即可
public class T33_SequenceOfBST {

    public static boolean VerifySquenceOfBST(int[] sequence){
        if(sequence == null || sequence.length<1){
            return false;
        }

        if(sequence.length <= 2){
            return true;
        }

        return digui(sequence,0,sequence.length-1);
    }

    public static boolean digui(int[] sequence, int i,int j){
        //结束条件：当只有一个数或两个数时可直接返回true
        if(i >= j-1){
            return true;
        }

        int temp = i;
        //注意使用while防止数组越界
        while(temp<j && sequence[temp] <= sequence[j]){
            temp++;
        }

        for(int k = temp; k<j;k++){
            if(sequence[k] < sequence[j]){
                return false;
            }
        }

        //递归 + 回溯
        return digui(sequence,i,temp-1) && digui(sequence,temp,j-1);
    }

}
