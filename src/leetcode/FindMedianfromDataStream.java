package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
*
* @author Scott
*/

    
public class FindMedianfromDataStream {
    
    
    private Queue<Long> small = new PriorityQueue(), 
                        large = new PriorityQueue();

   // [2,3,4]
   // large [2] small [-2]
    // large [2,3] small [-2]
    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
               ? large.peek()
               : (large.peek() - small.peek()) / 2.0;
    }
    
    // GIPlan
    
    class MaxComparator implements Comparator<Long>{
    
            @Override
            public int compare(Long o1, Long o2) {
                return (int)(o2-o1);
            }
            
    }   
    
    class MinComparator implements Comparator<Long>{
    
            @Override
            public int compare(Long o1, Long o2) {
                return (int)(o1-o2);
            }
            
    }   
    Comparator max = new MaxComparator();
    Comparator min = new MinComparator();
    PriorityQueue<Long> maxHeap = new PriorityQueue(max);
    PriorityQueue<Long> minHeap = new PriorityQueue(min);
    
    public void addNum(int num) {
        maxHeap.offer((long)num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size()
               ? maxHeap.peek()
               : (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
            
}
