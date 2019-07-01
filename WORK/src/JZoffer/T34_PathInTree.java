package JZoffer;

//？？？？？？？？
//二叉树中和为某一值的路径：   输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
//如： 10，5，12，4，7     输入值为22   则有  10，5，7   和  10，12两条路径都可以
import java.util.ArrayList;

public class T34_PathInTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //一个全局变量存储最终结果
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //新建一个动态数组存储每一个小结果
        findpath(root,target,new ArrayList<>());
        return result;
    }

    //递归
    private static void findpath(TreeNode root,int target, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.val);
        target -= root.val;

        //路径上的和相等且为根结点即满足条件
        if(target == 0 && root.left == null && root.right == null){
            //注意要用 new一个动态数组，避免加入多个引用指向同一个对象
            result.add(new ArrayList<>(list));
        }else{
            findpath(root.left,target,list);
            findpath(root.right,target,list);
        }
        //移除当前操作
        list.remove(list.size()-1);
    }
    //不用减去target的值：因为是值传递，都是函数栈中的局部变量，返回上一个函数栈时，上一个函数栈中的target是一个没减之前的。所以加不加是没有任何影响的

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        FindPath(root,22);
    }


}
