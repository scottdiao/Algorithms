package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
*
* @author Scott
*/
public class MeetingRooms  {
    public boolean canAttendMeetings(Interval[] intervals) {
      if (intervals == null)
        return false;
    
      // Sort the intervals by start time
      Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.start - b.start; }
      });
      
      for (int i = 0; i < intervals.length-1; i++)
        if (intervals[i].end > intervals[i + 1].start)
          return false;
      
      return true;
    }
}
