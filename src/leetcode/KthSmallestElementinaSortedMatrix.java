package leetcode;

import java.util.PriorityQueue;

/**
*
* @author Scott
*/
public class KthSmallestElementinaSortedMatrix  {
    
   class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    
   }
//matrix = [
//   [ 1,  5,  9],
//   [ 3,  7, 13],
//   [12, 13, 15]
//   ],
//k = 8,
//
//return 13.      pq = 1 5 9 -> 5 9 10 -> 9 10 12

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
//        Build a minHeap of elements from the first row.
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
//      Every time when you poll out the root(Top Element in Heap),
//      you need to know the row number and column number of that element
//      (so we can create a tuple class here), replace that root with the next element 
//      from the same column.
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
    
// The idea is totally wrong, can not iterative row by row, should poll the smallest value
// and insert the value which below to it in the same col
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//        Build a minHeap of elements from the first row.
        for(int j = 0; j < n; j++) pq.offer(matrix[0][j]);
//      Every time when you poll out the root(Top Element in Heap),
//      you need to know the row number and column number of that element
//      (so we can create a tuple class here), replace that root with the next element 
//      from the same column.
//        1 2
//        1 3

//[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]

//1 4 7 11 15 -> 2 4 7 11 15 -> 4 7 8 11 15 ->
        for(int i = 1; i < n; i++) {
            for(int j=0;j<n;j++){
                if(k<=1) break;
                k--;
                int t = pq.poll();
                pq.offer(matrix[i][j]);
            }
        }
        while(k>1){
            pq.poll();
            k--;
        }
           
        return pq.poll();
    }


// Binary Search
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            // count means how many numbers > mid
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
