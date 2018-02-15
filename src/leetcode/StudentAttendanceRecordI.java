package leetcode;
/**
*
* @author Scott
*/
public class StudentAttendanceRecordI  {
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}
