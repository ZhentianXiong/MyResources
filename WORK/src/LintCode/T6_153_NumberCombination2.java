package LintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T6_153_NumberCombination2 {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        /* write your code here */
    List<List<Integer>> res = new ArrayList<>();
        if(num == null || num.length == 0){
        return res;
    }
        Arrays.sort(num);
    dfs(res,new ArrayList<Integer>(),num,0,target);
        return res;
}

    public void dfs(List<List<Integer>> res,List<Integer> cur,int[] num, int index,int target){
        if(0 == target){
            res.add(new ArrayList<>(cur));
        }
        
        for(int i = index;i<num.length;i++){
            if(i != index && num[i] == num[i-1]){
                continue;
            }

            if(target < num[i]){
                break;
            }
            cur.add(num[i]);
            dfs(res,cur,num,i+1,target-num[i]);
            cur.remove(cur.size() - 1);
        }
    }

}
