package LintCode;

public class T5_596_SmallestSubTree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    TreeNode small = null;
    int sum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        dfs(root);
        return small;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int temp = left + right + root.val;
        if(temp < sum){
            sum = temp;
            small = root;
        }
        return temp;
    }

}
