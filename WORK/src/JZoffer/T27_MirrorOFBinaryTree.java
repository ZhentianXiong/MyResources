package JZoffer;

import java.util.LinkedList;
import java.util.Stack;

//二叉树的镜像   :  3-4-5 对称变换为镜像  5-4-3
//思路：  二叉树的递归遍历  前序遍历
//循环实现：  需要借助 栈
public class T27_MirrorOFBinaryTree {

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val =val;
        }
    }

    //递归实现
    public static void Mirror(TreeNode root){
        //为空 或为 叶子节点 直接退出
        if(root == null || (root.left == null && root.right == null)){
            return ;
        }

        //处理根结点  左右子树互换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //递归左右子树
        Mirror(root.left);
        Mirror(root.right);
    }

    //循环实现 : 借助   栈
    public static void Mirror2(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            //操作当前栈顶的元素
            TreeNode current = stack.pop();
            swap(current);

            //栈存储即将要操作的左右节点
            if(current.left != null){
                stack.push(current.left);
            }
            if(current.right != null){
                stack.push(current.right);
            }
        }
    }

    public static void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
