package LintCode;

import java.util.ArrayList;
import java.util.List;

public class T5_480_BinaryTreePaths {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // write your code
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        dfs(result,new String(),root);
        return result;
    }

    public void dfs(List<String> result, String str,TreeNode root){
        if(root == null){
            result.add(str.substring(0,str.length()-2));
            return;
        }

        str = str + root.val + "->";
        if(root.left == null && root.right == null){
            dfs(result,str,root.left);
        }else{
            if(root.left != null){
                dfs(result,str,root.left);
            }
            if(root.right != null) {
                dfs(result, str, root.right);
            }
        }
    }


}
