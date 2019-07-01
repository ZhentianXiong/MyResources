package LintCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T4_615_CourseTable {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if(numCourses < 2 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0){
            return true;
        }

        if(prerequisites[0].length != 2){
            return false;
        }

        //有向图中没有环：即从入度为0的节点开始，每到达一个节点，就把该节点的入度减1，直至最后看是否所有节点入度都为0了
        int[] du = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){
            if(map.containsKey(prerequisites[i][1])){
                List<Integer> temp = map.get(prerequisites[i][1]);
                temp.add(prerequisites[i][0]);
                du[prerequisites[i][0]]++;
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],temp);
                du[prerequisites[i][0]] = 1;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        //处理入度为0的节点
        for(int i=0; i<numCourses;i++){
            for(int j=0; j<numCourses;j++){
                if(du[j] == 0){
                    result.add(j);
                    du[j] = -1;
                    if(map.containsKey(j)) {
                        List<Integer> temp = map.get(j);
                        for (Integer e : temp) {
                            du[e]--;
                        }
                    }
                }
            }
        }

        return result.size() == numCourses;
    }

}


/*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] edge = new ArrayList[numCourses];

        for(int i =0; i< numCourses; i++){
            edge[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i <prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
            edge[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i =0 ; i< inDegree.length; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int count =0;
        while(!queue.isEmpty()){
            int v =queue.poll();
            count++;
        int size = edge[v].size();
        for(int i =0; i< size; i++){
            inDegree[edge[v].get(i)]--;
            if(inDegree[edge[v].get(i)] ==0){

                queue.offer(edge[v].get(i));
            }

        }


        }

        return count  == numCourses;
    }
*/