package JZoffer;

//？？？？？
//对称的二叉树 :   请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
//数学归纳法：  找规律，可以发现前序遍历   父左右  的对称遍历法  父右左   两者相同即为对称的二叉树   但是同时也要考虑到 null 的问题
public class T28_SymmetricalBinaryTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean isSymmetrical(TreeNode pRoot){

        //空二叉树  返回true
        if(pRoot == null){
            return true;
        }

        //不能是pRoot.left he pRoot.right    ？？？？？？
        return isSymme(pRoot,pRoot);
    }

    //传入同一棵树 分别用前序和前序的对称算法进行比对
    public static boolean isSymme(TreeNode lefttree, TreeNode righttree){

        //异或算法： 相同正确，不同错误  （先与再或）
        //两者都为空 正确
        if(lefttree == null && lefttree == null){
            return true;
        }

        //两者有且仅有一个为空 错误
        if(lefttree == null || righttree == null){
            return false;
        }

        //两者都不为空才比较值的大小
        //注意记得是比较  val 不是比较引用
        if(lefttree.val != righttree.val){
            return false;
        }

        //递归左右子树
        return isSymme(lefttree.left,righttree.right)
                && isSymme(lefttree.right,righttree.left);
    }

}
