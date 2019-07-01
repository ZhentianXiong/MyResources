package JZoffer;

//平衡二叉树：   如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//思路： 遍历每个节点，计算其左右子节点的深度差，但是会有很多重复计算
//  后序遍历：  左右父    每次遍历到即知道其深度，从而直接判断，减少重复计算
public class T55_BalanceBinaryTree_2 {

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    static boolean isBalanced = true;
    public static boolean isBalancedBinaryTree(TreeNode root){
        if(root == null|| (root.left == null && root.right == null)){
            return false;
        }

        digui(root);
        return isBalanced;
    }

    public static int digui(TreeNode root){
        //为空 或 已经不是平衡树就不需要判断了   ---   剪枝
        if(root == null || !isBalanced){
            return 0;
        }

        //左右节点深度
        int leftlen = digui(root.left);
        int rightlen = digui(root.right);
        if(Math.abs(leftlen-rightlen) > 1){
            isBalanced = false;
        }

        return 1+Math.max(leftlen,rightlen);
    }




}
