package NiuKe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T1_2_PrintBinaryTree {

    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public int[][] printTree(TreeNode root) {
        // write code here
        if(root == null){
            return null;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        TreeNode nextLast = root;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left != null){
                queue.offer(temp.left);
                nextLast = temp.left;
            }
            if(temp.right != null){
                queue.offer(temp.right);
                nextLast = temp.right;
            }

            if(temp == last){
                result.add(temp.val);
                res.add(result);
                result = new ArrayList<>();
                last = nextLast;
            }else{
                result.add(temp.val);
            }
        }

        int[][] lastresult = new int[res.size()][];
        for(int i=0;i<res.size();i++){
            lastresult[i] = new int[res.get(i).size()];
            for(int j=0;j<res.get(i).size();j++){
                lastresult[i][j] = res.get(i).get(j);
            }
        }
        return lastresult;
    }

}
