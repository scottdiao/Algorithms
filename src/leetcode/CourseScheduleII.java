package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
//
//4, [[1,0],[2,0],[3,1],[3,2]]
//There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
//
//Note:
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//You may assume that there are no duplicate edges in the input prerequisites.

public class CourseScheduleII {
    
    // 拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList(numCourses);
        initialiseGraph(indegree, adjs, prerequisites);
        //return solveByBFS(indegree, adjs);
        return solveByBFS(indegree, adjs);
    }
    
    // List<List<Integer>> 也可以表示有向图
    private void initialiseGraph(int[] indegree, List<List<Integer>> adjs, int[][] prerequisites){
        int n = indegree.length;
        while (n-- > 0) adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }
    
    // 拓扑排序
    private int[] solveByBFS(int[] indegree, List<List<Integer>> adjs){
        int[] order = new int[indegree.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                indegree[to]--;
                if (indegree[to] == 0) toVisit.offer(to);
            }
        }
        return visited == indegree.length ? order : new int[0]; 
    }
    
}
