package JZoffer;

import java.util.ArrayList;

//从上往下打印二叉树：   从上往下打印出二叉树的每个节点，同层节点从左至右打印。（广度优先遍历二叉树）
//思路：  实际上是   按层遍历   递归解法
public class T32_PrintTreeFromTopToBottom_1 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static ArrayList<Integer> printTree(TreeNode root){

        ArrayList<Integer> result = new ArrayList<>();

        //不能返回null， 会空指针异常，返回空的引用
        if(root == null){
            return result;
        }

        //先加 父节点
        result.add(root.val);
        printTreeDigui(root,result);
        return result;
    }

    public static void printTreeDigui(TreeNode root, ArrayList<Integer> result){
        //加左右节点
        if(root.left != null){
            result.add(root.left.val);
        }

        if(root.right != null){
            result.add(root.right.val);
        }

        //左右子树不为空时递归
        if(root.left != null) {
            printTreeDigui(root.left, result);
        }

        if(root.right != null) {
            printTreeDigui(root.right, result);
        }
    }



}
