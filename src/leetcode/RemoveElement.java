package leetcode;

public class RemoveElement {

	public static void main(String[] args) {

	}
	public int removeElement(int[] nums, int val) {
            int idx = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] != val){
                    nums[idx++] = nums[i]; 
                }
            }
            return idx;
    }

}
