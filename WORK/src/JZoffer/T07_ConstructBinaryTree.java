package JZoffer;

//重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
//传入数组和下标，可理解为截取数组中的一部分
//先取先序的第一个为根结点，然后在中序中找到根结点，左边即为左子树，右边为右子树，然后把左右子树递归解决
public class T07_ConstructBinaryTree {

    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x)
        {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in)
    {
        //输入长度为空，或前序中序数组长度不相等则返回null
        if(pre == null || in ==null || pre.length != in.length || pre.length<1)return null;
        //初始化递归
        return digui(pre,0,pre.length-1,in,0,in.length-1);
    }

    public static TreeNode digui(int[] pre, int pstart, int pend, int[] in, int instart, int inend)
    {
        //两个数组长度必须相等，且前序start必须小于等于end
        if((pend-pstart) != (inend-instart) || pend<pstart)return null;
        //建立本轮的根结点
        TreeNode result = new TreeNode(pre[pstart]);
        //只有一个节点，直接返回该节点
        if((pend-pstart) == 0)return result;
        //split：根结点在中序中的位置
        int split=0;
        for(int i=instart;i<=inend;i++)
        {
            if(pre[pstart] == in[i]){split = i; break;}
        }
        //注意下标的一般性，可能会无形中省略下下标0
        result.left = digui(pre,pstart+1,pstart+split-instart,in,instart,split-1);
        result.right = digui(pre,pstart+split-instart+1,pend,in,split+1,inend);
        //返回递归后的结果
        return result;
    }

    //递归打印树（中序）
    public static void printTree(TreeNode tree)
    {
        if(tree != null)
        {
            printTree(tree.left);
            System.out.print(tree.val);
            printTree(tree.right);
        }
    }

    public static void main(String[] args)
    {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        printTree(reConstructBinaryTree(pre,in));
    }


}
