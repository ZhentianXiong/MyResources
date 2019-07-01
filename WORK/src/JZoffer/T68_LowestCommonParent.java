package JZoffer;

//??????????
//三种解法：  仔细学习
import java.util.*;
public class T68_LowestCommonParent {

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    //1、二叉搜索树:   直接比较值的大小即可，一大一小即为该节点，否则往下递归
    public static TreeNode lowestCommon(TreeNode root,TreeNode node1,TreeNode node2){
        if(root.val > node1.val && root.val > node2.val){
            return lowestCommon(root.left,node1,node2);
        }

        if(root.val < node1.val && root.val < node2.val){
            return lowestCommon(root.right,node1,node2);
        }

        return root;
    }


/*     public static void main(String args[]) {
        //放树节点的数组
         TreeNode node[] = new TreeNode[7];
         //给节点赋值的数组
         int arr[] = {4,2,6,1,3,5,7};
         //处理引用关系
         //从0开始对节点编号的话，第i个节点的左子节点下标为2*i+1，右子节点为2*i+2
         for(int i=6;i>=0;i--) {
             node[i] = new TreeNode(arr[i]);
             //不是叶子节点的话(叶子节点没有子节点)，把引用指向叶子节点
             if (i < node.length/2) {
                 node[i].left = node[2 * i + 1];
                 node[i].right = node[2 * i + 2];
             }
         }
         *//*
                 4
                /  \
               2    6
              / \  / \
             1   3 5  7
          *//*
         //找值为3的节点和值为5的节点的LCA
         TreeNode result = lowestCommon(node[0],node[4],node[5]);
         System.out.println(result.val);
    }*/




    //2、不是二叉搜索树，但是有指向父节点的指针：    =   两个链表的第一个公共节点   Y字型
    /*3、如果只是一个包含父到子的指针的普通树：
       3.1）如果不能使用额外空间，从根节点开始判断他的子树是否包含那两个节点，找到最小的的子树即可
            时间复杂度o(n^2)(此为最差，平均不太好算。。。),空间复杂度为o(1)
       3.2) 如果能用额外空间，可以遍历两次(深度优先)获取根节点到那两个节点的路径，然后求两个路径的最后一个公共节点
           时间复杂度o(n)，空间复杂度o(logn)   */

    public static class CommonTreeNode{
        public char val;
        public List<CommonTreeNode> children;
        public CommonTreeNode(char val){
            this.val = val;
            children = new LinkedList<>();
        }
        public void addChildren(CommonTreeNode... children){
            for(CommonTreeNode child:children)
                this.children.add(child);
        }
    }
    // 3.1所述的解法
    public static CommonTreeNode getLastParent1(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
        if(root==null || node1==null || node2==null || !isInSubTree(root,node1,node2))
            return null;
        CommonTreeNode curNode = root;
        while (true){
            for(CommonTreeNode child:curNode.children){
                if(isInSubTree(child,node1,node2)){
                    curNode = child;
                    break;
                }
                if(child==curNode.children.get(curNode.children.size()-1))
                    return curNode;
            }
        }
    }
    public static boolean isInSubTree(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
        Queue<CommonTreeNode> queue = new LinkedList<>();
        CommonTreeNode temp = null;
        int count = 0;
        queue.add(root);
        while (count!=2 && !queue.isEmpty()){
            temp = queue.poll();
            if(temp==node1||temp==node2)
                count++;
            if(!temp.children.isEmpty())
                queue.addAll(temp.children);
        }
        if(count==2)
            return true;
        return false;
    }


    // 3.2所述的解法
    public static CommonTreeNode getLastParent2(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
        List<CommonTreeNode> path1 = new ArrayList<>();
        List<CommonTreeNode> path2 = new ArrayList<>();
        getPath(root,node1,path1);
        getPath(root,node2,path2);
        CommonTreeNode lastParent = null;
        for(int i=0;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)==path2.get(i))
                lastParent = path1.get(i);
            else
                break;
        }
        return lastParent;
    }
    public static boolean getPath(CommonTreeNode root,CommonTreeNode node,List<CommonTreeNode> curPath){
        if(root==node)
            return true;
        curPath.add(root);
        for(CommonTreeNode child:root.children){
            if(getPath(child,node,curPath))
                return true;
        }
        curPath.remove(curPath.size()-1);
        return false;
    }

    public static void main(String[] args){
        CommonTreeNode root = new CommonTreeNode('A');
        CommonTreeNode b = new CommonTreeNode('B');
        CommonTreeNode c = new CommonTreeNode('C');
        CommonTreeNode d = new CommonTreeNode('D');
        CommonTreeNode e = new CommonTreeNode('E');
        CommonTreeNode f = new CommonTreeNode('F');
        CommonTreeNode g = new CommonTreeNode('G');
        CommonTreeNode h = new CommonTreeNode('H');
        CommonTreeNode i = new CommonTreeNode('I');
        CommonTreeNode j = new CommonTreeNode('J');
        root.addChildren(b,c);
        b.addChildren(d,e);
        d.addChildren(f,g);
        e.addChildren(h,i,j);
        System.out.println(getLastParent1(root,f,h).val);
        System.out.println(getLastParent2(root,f,h).val);
        System.out.println(getLastParent1(root,h,i).val);
        System.out.println(getLastParent2(root,h,i).val);

    }
}




