package Algorithms;
/**
*
* @author Scott
*/
public class InsertionSort  {
    
    public static void main(String[] args) {
        int[] a = new int[]{1,15,5,19,6,88,79,85,42,22};
        a = insertionSort(a);
        for(Integer i : a){
            System.out.println(i);
        }
    }
    
    public static int[] insertionSort(int[] nums){
        int n = nums.length;
        for(int i=1;i<n;i++){
            int key = nums[i];
            int j = i-1;
            //如果nums[j]>key 将所有的数向右移一位
            while(j>0&&nums[j]>key){
                nums[j+1]=nums[j];
                j=j-1;
            }
            nums[j+1]=key;
        }
        return nums;
    }
        
}
