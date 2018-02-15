package leetcode;
/**
*
* @author Scott
*/
public class NumberofConnectedComponentsinanUndirectedGraph  {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i; 

        for(int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2) {      
                roots[root1] = root2;  // union
                n--;
            }
        }
        return n;
    }

//  2 2 5 2 1 3 2 4 2 3
//  0 1 2 3 4 5 6 7 8 9
    public int find(int[] roots, int id) {
        while(roots[id] != id) {
//          Bonus: path compression can reduce time by 50%.
            roots[id] = roots[roots[id]];  // optional: path compression   if some nodes are connected, set them to the same value
            id = roots[id];
        }
        return id;
    }
}
