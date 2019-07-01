package JZoffer;

import java.util.Stack;
//序列化二叉树：    请实现两个函数，分别用来序列化和反序列化二叉树  "1,2,4,$,$,$,3,5,$,$,6,$,$"

public class T37_SerializeBinaryTrees {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //序列化：前序遍历即可  可用递归和非递归两种方式
    public String Serialize(TreeNode root) {
        //方便字符串拼接
        StringBuffer result = new StringBuffer();

        if(root == null){
            return result.toString();
        }

        //非递归，用栈  栈里面存储的是当前操作节点的父节点，方便找到其兄弟节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                result.append(current.val).append(",");
                current = current.left;
            }else{
                result.append("$,");
                current = stack.pop();
                current = current.right;
            }
        }
        return result.toString();
    }

    //反序列化： 用递归的方式
    public TreeNode Deserialize(String str) {
        if(str == null || str.length()<1){
            return null;
        }

        String[] value = str.split(",");
        return deserDigui(value);
    }

    int index = -1;
    public TreeNode deserDigui(String[] value){
        index++;
        TreeNode current = null;
        //数组未越界，且当前操作不为 $ ，为$可直接跳过，到下一个字符串
        if(index < value.length && !value[index].equals("$")){
            //父节点
            current = new TreeNode(Integer.parseInt(value[index]));
            //递归左右子树
            current.left = deserDigui(value);
            current.right = deserDigui(value);
        }
        return current;
    }


}
