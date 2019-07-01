package JZoffer;

//二叉搜索树与双向链表：   输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
//思路：因为要转换成有序的双向链表，所以用   中序遍历二叉搜索树（栈）   最好
import java.util.Stack;

public class T36_BSTtoLinkedList {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode Convert(TreeNode root) {
        if(root == null){
            return root;
        }

        //pre: 前一个节点 用于双向链接  current：当前操作的节点   result：仅指向头节点用于结果返回
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode result = null;
        TreeNode current = root;

        //当前节点不为空 或 栈不为空就一直循环
        while(current != null || !stack.isEmpty()){
            //先把路径上的节点压入栈，然后一直往左找节点
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                //左边处理完，处理栈中的父节点
                current = stack.pop();
                if(pre == null){
                    //初始化输出结果
                    pre = current;
                    result = pre;
                }else{
                    //双向链接
                    pre.right = current;
                    current.left = pre;
                    pre = current;
                }
                //处理右子树
                current = current.right;
            }
        }
        return result;

    }



}
