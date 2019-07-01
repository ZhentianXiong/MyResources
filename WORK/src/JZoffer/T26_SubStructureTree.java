package JZoffer;

//树的子结构：   输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
//思路： 先在树 A 中遍历找到与树 B 根结点相同的节点，然后再判断根结点下面是否相同
//递归的方法遍历树
public class T26_SubStructureTree {

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2){
        //任意为空即返回false
        if(root1 == null || root2 == null){
            return false;
        }

        boolean flag = false;

        //两棵树根结点相同，直接比较下部分是否相同
        if(root1.val == root2.val){
            flag = isSame(root1,root2);
        }

        //若没有，则从 A 左子树中找到与树 B 根结点相同的节点
        if(!flag){
            flag = HasSubtree(root1.left,root2);
        }

        if(!flag){
            flag = HasSubtree(root1.right,root2);
        }

        //任一符合条件即可完成退出
        return flag;

        //return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        //直接判断 根 左子树 右子树


    }


    public boolean isSame(TreeNode root1,TreeNode root2){
        // B 遍历完了，说明都符合
        if(root2 == null)return true;

        //B没遍历完，A已经没有了
        if(root1 == null)return false;

        //两者不相等，直接返回false
        if(root1.val != root2.val)return false;

        //两者目前根结点相等，则递归判断左右子树  都相等才行 &&
        return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
    }


}
