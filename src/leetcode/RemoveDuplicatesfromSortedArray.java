package leetcode;


public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,3,3,3,3,4,5};
		System.out.println(removeDuplicates(a));

	}
        
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for(int n : nums)
                if(i < 1 || n > nums[i - 1]) 
                    nums[i++] = n;
            return i;
        }
//	public static int removeDuplicates(int[] nums) {
//            int count=1;
//
//            for(int i=0;i<nums.length-1;i++){
//                if(nums[i]!=nums[i+1]){
//                    nums[count]=nums[i+1];
//                    count++;
//                }
//            }
//
//            return count;
//	}

}
