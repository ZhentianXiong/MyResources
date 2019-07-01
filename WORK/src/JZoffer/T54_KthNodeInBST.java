package JZoffer;

import apple.laf.JRSUIUtils;

import java.util.Stack;

//二叉搜索树的第K个节点：    给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
//二叉搜索树是有顺序的，用   中序遍历（非递归：每个节点都会一次压入栈）   即可按顺序遍历
public class T54_KthNodeInBST {

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }

    static int num = 0;

    public static TreeNode kthNode(TreeNode root, int k){
        if(root == null || k <= 0){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = null;
        while(root != null || !stack.isEmpty()){
            //先把父节点全部压入栈
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            //弹出左子叶节点，随后弹出各父节点
            root = stack.pop();
            //所有节点都会入栈，弹出顺序即遍历顺序
            num++;
            if(num == k)result = root;
            //转向操作右子树
            root = root.right;
        }
        return result;
    }

    //解法2：   递归解法
    static int count = 0;
    public static TreeNode kthNode_digui(TreeNode root,int k){
        if(root == null || k == 0){
            return null;
        }

        TreeNode retnode = kthNode(root.left,k);

        if(retnode != null){
            return retnode;
        }

        count++;
        if(count == k){
            return root;
        }

        retnode = kthNode(root.right,k);
        if(retnode != null){
            return retnode;
        }

        return null;
    }



}
