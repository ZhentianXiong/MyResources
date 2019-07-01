package NiuKe;


public class T7_8_CheckBalanceTree {

    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean check(TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }

        if(height(root) < 1){
            return false;
        }else{
            return true;
        }
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftheight = height(root.left);
        int rightheight = height(root.right);
        if(leftheight < 0 || rightheight < 0){
            return -1;
        }
        if(Math.abs(leftheight-rightheight) > 1){
            return -1;
        }
        return Math.max(leftheight,rightheight)+1;
    }

}
