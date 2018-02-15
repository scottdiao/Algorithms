package leetcode;

//X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how you place parentheses.
//i.e no matter how you place parentheses, X1 always goes to the numerator and X2 always goes to the denominator.
//Hence you just need to maximize Y. And Y is maximized when it is equal to X3 *..*Xn. 
//So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2
public class OptimalDivision {
     public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                builder.append("/(").append(nums[i]);
            } else {
                builder.append("/").append(nums[i]);
            }
        }
        
        return nums.length > 2 ? builder.append(")").toString() : builder.toString();
    }
}
