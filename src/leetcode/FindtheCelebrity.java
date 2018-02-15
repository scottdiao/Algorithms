package leetcode;
/**
*
* @author Scott
*/
public class FindtheCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
//         if a knows b then a < b, if a does not know b, a > b
//   Then if there is a celebrity, he/she must be the "maximum" of the n people.
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}
