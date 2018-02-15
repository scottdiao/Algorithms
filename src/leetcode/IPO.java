package leetcode;

import java.util.PriorityQueue;

/**
*
* @author Scott
*/
public class IPO {
// The idea is each time we find a project with max profit and within current capital capability.
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    //  This PriorityQueue sort by capital increasingly
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro  = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        
        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[] {Capital[i], Profits[i]});
        }
        
//Keep polling pairs from pqCap until the project out of current capital capability. Put them into
//PriorityQueue pqPro which sort by profit decreasingly. It store all the project we can afford,
//we just choose the highest profit one greedy each turn
        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }
            
            if (pqPro.isEmpty()) break;
            
            W += pqPro.poll()[1];
        }
        
        return W;
    }
}
