package LintCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的广度优先遍历
public class T4_69_BFSTree {

  public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int k = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(k>0){
                TreeNode tempnode = queue.poll();
                k--;
                temp.add(tempnode.val);
                if(tempnode.left != null){
                    queue.offer(tempnode.left);
                }

                if(tempnode.right != null){
                    queue.offer(tempnode.right);
                }
            }
            res.add(temp);
        }

        return res;
    }


}
