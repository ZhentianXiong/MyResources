package NiuKe;

import java.util.ArrayList;
import java.util.Stack;

public class T7_2_DiguiTree {

    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int[][] convert(TreeNode root) {
        // write code here
        if(root == null){
            return null;
        }

        ArrayList<Integer> temp1 = preorder(root,new ArrayList<>());
        ArrayList<Integer> temp2 = inorder(root,new ArrayList<>());
        ArrayList<Integer> temp3 = afterorder(root,new ArrayList<>());
        int[][] res = new int[3][temp1.size()];
        int n = temp1.size();
        for(int i = 0; i<n;i++){
            res[0][i] = temp1.get(i);
            res[1][i] = temp2.get(i);
            res[2][i] = temp3.get(i);
        }
        return res;
    }

    public ArrayList<Integer> preorder(TreeNode root,ArrayList<Integer> temp){
        if(root != null) {
            temp.add(root.val);
            preorder(root.left, temp);
            preorder(root.right, temp);
        }
        return temp;
    }

    public ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> temp){
        if(root != null) {
            inorder(root.left, temp);
            temp.add(root.val);
            inorder(root.right, temp);
        }
        return temp;
    }

    public ArrayList<Integer> afterorder(TreeNode root,ArrayList<Integer> temp){
        if(root != null) {
            afterorder(root.left, temp);
            afterorder(root.right, temp);
            temp.add(root.val);
        }
        return temp;
    }

}
