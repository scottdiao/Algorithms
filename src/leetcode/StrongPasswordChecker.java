package leetcode;


//1.res denotes the minimum changes; a, A and d are the number of missing lowercase letters, uppercase letters and digits, respectively; arr is an integer array whose element will be the number of repeating characters starting at the corresponding position in the string.
//
//2.In the following loop we fill in the values for a, A, d and arr to identify the problems for each condition. The total number of missing characters total_missing will be the summation of a, A, d and fixing this problem takes at least total_missing changes.
//
//3.We then distinguish the two cases when the string is too short or too long. If it is too short, we pad its length to at least 6 (note in this case we've already inserted total_missing characters so the new length is the summation of the original length and total_missing).
//
//4.Otherwise, to fix the first condition, we need to delete over_len (number of surplus characters) characters. Since fixing the first problem also corrects the third one, we need to get rid of those parts from the arr array. And as I mentioned, we need to first turn all numbers in the arr array greater than 2 into the form of (3m + 2) and then reduce them all the way to 2 if over_len is still greater than 0. After that, we need to replace total_missing characters to fix the second problem, which also fixes part (or all) of the third problem. Therefore we only need to take the larger number of changes needed for fixing the second problem (which is total_missing) and for the third one (which is left_over, since it is the number of changes still needed after fixing the first problem).


public class StrongPasswordChecker  {
    public int strongPasswordChecker(String s) {
        int res = 0, a = 1, A = 1, d = 1;
        char[] carr = s.toCharArray();
        int[] arr = new int[carr.length];

        for (int i = 0; i < arr.length;) {
            if (Character.isLowerCase(carr[i])) a = 0;
            if (Character.isUpperCase(carr[i])) A = 0;
            if (Character.isDigit(carr[i])) d = 0;

            int j = i;
            while (i < carr.length && carr[i] == carr[j]) i++;
            // arr[i] stores how many consequence duplicate from index i
            arr[j] = i - j;
        }

        int total_missing = (a + A + d);

        if (arr.length < 6) {
            res += total_missing + Math.max(0, 6 - (arr.length + total_missing));

        } else {
            int over_len = Math.max(arr.length - 20, 0), left_over = 0;
            res += over_len;
            
            // aaaaaa l=6 we reduce to 5
            // aaaaaaaa l=8 we reduce to 6
       
            // aaaaa  we only need to replace the middle a 
           
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && over_len > 0; i++) {
//      k=1 remove arr[i]=3,6,9... first duplicate, then arr[i]-1, over_len-1, k=2 remove arr[i]=4,7,10... 
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) continue;
                    arr[i] -= Math.min(over_len, k);
                    over_len -= k;
                }
            }
            
            for (int i = 0; i < arr.length; i++) {
                // if we still have over_len, just remove the duplicate
                if (arr[i] >= 3 && over_len > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= over_len;
                    over_len -= need;
                }
                // if we do not have over_len, replace the middle one int each 5
                if (arr[i] >= 3) left_over += arr[i] / 3;
            }

            res += Math.max(total_missing, left_over);
        }

        return res;
    }
}
