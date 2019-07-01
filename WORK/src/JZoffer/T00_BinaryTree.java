package JZoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二叉树的各种遍历方法： DFS（栈）：前序（递归-非递归）、中序（递归-非递归）、后序（递归-非递归（两个栈-一个栈））；广度优先BFS（队列）
//递归：    节点不为空就可以继续递归   处理顺序不同而已
//非递归：   节点不为空或栈不为空就可以一直循环： 先把左边遍历完加入栈，然后栈不为空再依次处理父节点和右支路，
//广度优先： 队列
public class T00_BinaryTree {

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        preOrderDigui(root);
        System.out.println(resultPre);

        System.out.println(preorder(root));

        inOrderDigui(root);
        System.out.println(resultIn);

        System.out.println(inorder(root));

        postOrderDigui(root);
        System.out.println(resultPost);

        System.out.println(postorderTwoStack(root));

        System.out.println(postorderOneStack(root));

        System.out.println(BFS(root));

        System.out.println(DFS(root));
    }

    //先序：递归解法
    static ArrayList<Integer> resultPre = new ArrayList<>();
    public static void preOrderDigui(TreeNode root){
        if(root != null){
            resultPre.add(root.val);
            preOrderDigui(root.left);
            preOrderDigui(root.right);
        }
    }

    //先序：非递归  节点为空且栈为空时才结束循环
    public static ArrayList preorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return result;
    }

    //中序：递归解法
    static ArrayList<Integer> resultIn = new ArrayList<>();
    public static void inOrderDigui(TreeNode root){
        if(root != null){
            inOrderDigui(root.left);
            resultIn.add(root.val);
            inOrderDigui(root.right);
        }
    }

    //中序：非递归  栈为空且节点为空才终止循环
    public static ArrayList inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    //后序：递归解法
    static ArrayList<Integer> resultPost = new ArrayList<>();
    public static void postOrderDigui(TreeNode root){
        if(root != null){
            postOrderDigui(root.left);
            postOrderDigui(root.right);
            resultPost.add(root.val);
        }
    }

    //后序：非递归--两个栈   栈1存储暂时结果，栈2存储最终结果（依次弹出就是最终结果，所以从上到下顺序为：左右父），所以栈1存储的顺序为：从上到下：父-右左
    public static ArrayList postorderTwoStack(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if(temp.left != null) {
                stack1.push(temp.left);
            }
            if(temp.right != null) {
                stack1.push(temp.right);
            }
        }

        while(!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }
        return result;
    }

    //后序：非递归--一个栈  栈为空且节点为空时才终止循环
    public static ArrayList postorderOneStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            //标示是否处理父节点（false则处理右支路）
            boolean tag = true;
            //记录前一个处理的节点
            TreeNode prenode = null;
            while(!stack.isEmpty() && tag == true){
                root = stack.peek();
                //前一个处理的是右节点，然后处理父节点
                if(prenode == root.right){
                    root = stack.pop();
                    result.add(root.val);
                    if(!stack.isEmpty()){
                        prenode = root;
                    }else{
                        return result;
                    }
                }else{
                    root = root.right;
                    //还不到时候处理父节点，直接跳出处理右支路
                    tag = false;
                }

            }


        }
        return result;
    }

    //广度优先：非递归遍历 -- 队列从上至下从左至右实现即可   注意栈和队列都不可加入空
    public static ArrayList BFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            result.add(root.val);
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
        }
        return result;
    }

    //深度优先遍历：  栈  从左到右
    public static ArrayList DFS(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            result.add(root.val);
            if(root.right != null){
                stack.add(root.right);
            }
            if(root.left != null){
                stack.add(root.left);
            }
        }
        return result;
    }


}
