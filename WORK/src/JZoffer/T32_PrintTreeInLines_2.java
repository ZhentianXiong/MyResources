package JZoffer;

//把二叉树打印成多行  ：  从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
//8
//6 10
//5 7 9 11
//相比于上一小题： 增加一个变量来存储每行的值即可

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T32_PrintTreeInLines_2 {

    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> print(TreeNode root){

        //每一行都用一个动态数组来存
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        //记录每行的数目
        int linenumber = 1;

        while(linenumber > 0){

            //当前层节点数目
            int tempnumber = linenumber;
            //统计下一层节点数目
            linenumber = 0;
            ArrayList<Integer> lineresult = new ArrayList<>();

            for(int i=0;i<tempnumber;i++) {

                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.offer(temp.left);
                    linenumber++;
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                    linenumber++;
                }
                lineresult.add(temp.val);
            }
            result.add(lineresult);
        }

        return result;
    }


}
