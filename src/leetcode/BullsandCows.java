package leetcode;
/**
*
* @author Scott
*/
public class BullsandCows  {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;// <0 表示guess还有
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
    
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] nums = new int[10];
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) bull++;
            else{
                if(nums[secret.charAt(i)-'0']-->0) cow++;
                if(nums[guess.charAt(i)-'0']++<0) cow++;
            }
        }
        return bull+"A"+cow+"B";
    }
}
