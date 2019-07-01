package LintCode;

public class T5_900_CloestValue {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    //给一棵非空二叉搜索树以及一个target值，找到在BST中最接近给定值的节点值
    //递归实现：普通深度搜索   也可以循环实现
    public int closestValue(TreeNode root, double target) {
        // write your code here
        int a = root.val;
        TreeNode kid = a < target ? root.right : root.left;

        if(kid == null){
            return a;
        }

        int b = closestValue(kid,target);
        //递归返回值进行比较最小值
        return Math.abs(target-a) < Math.abs(target-b) ? a : b;
    }


}
