package leetcode;

import java.util.List;
import java.util.ArrayList;

//Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
//For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]


public class MissingRanges  {
    public static void main(String[] args) {
            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);
    }
    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList();
        

        // the next number we need to find
        int next = lo;
        boolean overflow = false;

        for (int i = 0; i < a.length; i++) {
          // not within the range yet
          if (a[i] < next) continue;

          // continue to find the next one
          if (a[i] == next) {
              //在不overflow的情况下，如果a[i]==next 只需将next+1
            if(next!=Integer.MAX_VALUE) next++; // every increase option could result in overflow
            if(lo==hi&&a[i]==lo) return new ArrayList(); // in case {1,2,3} lo:1 hi:1 should return 0
            continue;
          }

          // get the missing range string format
          res.add(getRange(next, a[i] - 1));

          // now we need to find the next number
          if(a[i]==Integer.MAX_VALUE){
              next = a[i];
              overflow=true;
          } 
          else{ next = a[i] + 1;}
        
          
        }

        // do a final check
        if (next <= hi&&!overflow) res.add(getRange(next, hi));

        return res;
      }

      String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
      }
}
