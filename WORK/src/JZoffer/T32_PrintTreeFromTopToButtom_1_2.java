package JZoffer;

//从上往下打印二叉树：   从上往下打印出二叉树的每个节点，同层节点从左至右打印。（按层遍历）（广度优先遍历二叉树）
// 借助 队列 解法
//广度优先遍历有向图也可以通过队列实现，树是图的一种特殊退化形式

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T32_PrintTreeFromTopToButtom_1_2 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static ArrayList<Integer> printTree(TreeNode root){

        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        //一直循环到队列为空
        while(!queue.isEmpty()){
            //用一个节点暂存队列中弹出的值
            TreeNode tempNode = queue.poll();

            //左右子树入队列
            if(tempNode.left != null){
                queue.offer(tempNode.left);
            }

            if(tempNode.right != null){
                queue.offer(tempNode.right);
            }

            result.add(tempNode.val);
        }

        return result;
    }

}
