package leetcode;

public class SearchInsertPosition {

	public static void main(String[] args) {
            int[] a = {1};
            System.out.println(searchInsert(a,1));
	}
        public static int searchInsert(int[] nums, int target) {
            int l=0,h=nums.length-1;
            int mid = 0;
            while(h>l){
                mid = l+(h-l)/2;
                System.out.println("mid:"+mid);
                if(nums[mid]<target){
                    l=mid+1;
                }else if(nums[mid]>target){
                    h=mid-1;
                }else{
                    
                    return mid;
                }
            }
            return nums[l]>target?l:l+1;
        }
        
//        public static int searchInsert(int[] nums, int target) {
//            int l=0,h=nums.length-1,mid=0;
//            while(l<=h){
//                mid=(l+h)/2;
//                if(nums[mid]<target)l=mid+1;
//                else if(nums[mid]==target) return mid;
//                else h=mid-1;
//            }
//            return l;
//               
//        }
        
//	public static int searchInsert(int[] nums, int target) {
//            for(int i=0;i<nums.length;i++){
//                if(nums[i]==target){
//                    return i;
//                }else{
//                    if(i>0){
//                        if(nums[i-1]<target&&nums[i]>target){
//                        return i;
//                    }
//                    }else{
//                        if(target<nums[0]){
//                                return 0;
//                        }
//                    }
//                }
//            }
//            return nums.length;
//         }
}
