package JZoffer;

import java.util.ArrayList;
import java.util.Stack;

//按之字形顺序打印二叉树:    请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
//多个队列之间转换不会改变元素顺序，  多个栈之间转换才会改变元素的相对顺序（本题：两个栈）
//一个栈存  左右；   一个栈存  右左
//第一层： 先存左再存右    第二层：先存右再存左

public class T32_PrintTreeInZigzag_3 {

    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode root){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Stack<TreeNode> stacklr = new Stack<>();
        Stack<TreeNode> stackrl = new Stack<>();

        stackrl.push(root);
        int layer = 1;

        //用一个栈的引用指向两者中非空的那一个，两个栈之间来回跳转
        Stack<TreeNode> stack = stackrl;

        //当两个栈都为空时处理完结束
        while(!stack.isEmpty()){
            ArrayList<Integer> lineresult = new ArrayList<>();
            //操作一层
            while(!stack.isEmpty()){
                TreeNode temp = stack.pop();
                lineresult.add(temp.val);

                //奇数层 左右
                if((layer & 1) == 1){
                    if(temp.left != null){
                        stacklr.push(temp.left);
                    }

                    if(temp.right != null){
                        stacklr.push(temp.right);
                    }
                }else{
                    //偶数层： 右左
                    if(temp.right != null){
                        stackrl.push(temp.right);
                    }

                    if(temp.left != null){
                        stackrl.push(temp.left);
                    }
                }
            }

            result.add(lineresult);
            layer++;
            //指向两者中非空的那一个
            stack = stacklr.isEmpty() ? stackrl : stacklr;
        }

        return result;

    }

}
