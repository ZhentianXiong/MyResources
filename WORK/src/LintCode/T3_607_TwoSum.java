package LintCode;

import java.util.ArrayList;

public class T3_607_TwoSum {

    //可考虑用两个数据结构：arraylist + hashmap(确定一个数，用于加快查找另一个差值的速度)
    ArrayList<Integer> arrayList = new ArrayList<>();
    public void add(int number) {
        // write your code here
        arrayList.add(number);
    }


    public boolean find(int value) {
        // write your code here
        for(int i=0;i<arrayList.size()-1;i++){
            for(int j=i+1;j<arrayList.size();j++){
                if(value == arrayList.get(i)+arrayList.get(j)){
                    return true;
                }
            }
        }
        return false;
    }

}
