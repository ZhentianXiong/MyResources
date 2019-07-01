package JZoffer;

//二叉树的深度：   输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
//树的深度 = 1（本节点） + 左右子树的最大深度   递归
public class T55_DepthOfTree_1 {

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    static int depth = 0;
    public static int depthOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        depth = 1 + Math.max(depthOfTree(root.left),depthOfTree(root.right));
        return depth;
    }

}
