package JZoffer;

//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
//深刻理解中序：    左 -> 父 -> 右
//若有右节点： 则直接找其右节点的最左子节点即可
//若无右节点： 则需要向上回查
//  若该节点为其父节点的左子节点，则直接返回其父节点
//  若为其父节点的右子节点，则一直向上找到某个节点为其父节点的左子节点，然后返回该节点的父节点
//一定要注意到根结点的情况
public class T08_nextTreeNode {

    private static class TreeLinkNode
    {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        TreeLinkNode(int value)
        {
            this.val = value;
        }
    }

    public static TreeLinkNode nextTreeNode(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        //有右节点，不用考虑根节点
        if(pNode.right != null)
        {
            pNode = pNode.right;
            while(pNode.left != null)
            {
                pNode = pNode.left;
            }
            return pNode;
        }
        else{
            //无右节点，向上查，若已经为根结点了直接退出
            if(pNode.next == null)return null;
            //无右节点，且其为其父节点的左子节点
            if(pNode.next.left == pNode) return pNode.next;
            else
            {
                //无右节点，且其为其父节点的右子节点，一直向上遍历到其为某个节点的左分支
                while(pNode == pNode.next.right)
                {
                    pNode = pNode.next;
                    //若为根结点了，则直接退出
                    if(pNode.next == null)return null;
                }
                return pNode.next;
            }
        }
    }


}
