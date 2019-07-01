package NiuKe;

import java.util.Stack;

public class T7_6_SerialzeBinaryTree {

    class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public String toString(TreeNode root) {
        // write code here
        if(root == null){
            return null;
        }

        StringBuilder res = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while(temp != null || !stack.isEmpty()){
            if(temp != null){
                res.append(temp.val).append("!");
                stack.push(temp);
                temp = temp.left;
            }else{
                res.append("#").append("!");
                temp = stack.pop();
                temp = temp.right;
            }
        }

        res.append("#").append("!");
        return res.toString();
    }

}
