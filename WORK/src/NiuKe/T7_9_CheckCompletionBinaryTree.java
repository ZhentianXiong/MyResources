package NiuKe;

public class T7_9_CheckCompletionBinaryTree {

    public boolean chk(T7_6_SerialzeBinaryTree.TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }

        if(root.right != null && root.left == null){
            return false;
        }

        boolean right = chk(root.right);
        boolean left = chk(root.left);

        if(right == false || left == false){
            return false;
        }
        return true;
    }

}
