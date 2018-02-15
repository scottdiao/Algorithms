package leetcode;

import java.util.LinkedList;
import java.util.Queue;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
public class NestedListWeightSum {
    
    // DFS
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }


    // BFS
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null){
            return 0;
        }
    
        int sum = 0;
        int level = 1;

        Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
        while(queue.size() > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                NestedInteger ni = queue.poll();

                if(ni.isInteger()){
                    sum += ni.getInteger() * level;
                }else{
                    queue.addAll(ni.getList());
                }
            }

            level++;
        }
        return sum;
    }

}
