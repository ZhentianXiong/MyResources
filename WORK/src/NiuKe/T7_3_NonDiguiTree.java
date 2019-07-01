package NiuKe;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Stack;

public class T7_3_NonDiguiTree {

    public class TreeNode{
        int val = 0;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int[][] convert(TreeNode root) {
        // write code here
        if(root == null){
            return null;
        }

        ArrayList<Integer> temp1 = preorder(root);
        ArrayList<Integer> temp2 = inorder(root);
        ArrayList<Integer> temp3 = afterorder(root);

        int n = temp1.size();
        int[][] res = new int[3][n];
        for(int i = 0;i<n;i++){
            res[0][i] = temp1.get(i);
            res[1][i] = temp2.get(i);
            res[2][i] = temp3.get(i);
        }
        return res;
    }

    public ArrayList<Integer> preorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }

    public ArrayList<Integer> inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public ArrayList<Integer> afterorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode pre = null;
            boolean flag = true;

            while(!stack.isEmpty() && flag == true){
                root = stack.peek();
                if(pre == root.right){
                    root = stack.pop();
                    res.add(root.val);
                    if(!stack.isEmpty()){
                        pre = root;
                    }else{
                        return res;
                    }
                }else{
                    root = root.right;
                    flag = false;
                }
            }
        }
        return res;
    }


}
