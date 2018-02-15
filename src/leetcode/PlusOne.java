package leetcode;

//Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
//
//You may assume the integer do not contain any leading zero, except the number 0 itself.
//
//The digits are stored such that the most significant digit is at the head of the list

public class PlusOne {

	public static void main(String[] args) {
//            initilize int array is 0  Integer array is null
		int[][] newNumber = new int [3][3];
		System.out.println(newNumber[0][0]);

	}
        
        public static int[] plusOne(int[] digits) {
            int n = digits.length;
            for(int i=n-1; i>=0; i--) {
                if(digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }

                digits[i] = 0;
            }
            // 循环到这里还没return证明就是1000000000
            int[] newNumber = new int [n+1];
            newNumber[0] = 1;

            return newNumber;
         }
//	public static int[] plusOne(int[] digits) {
//		int carry=0;
//		int[] res = new int[digits.length];
//		int sum=digits[digits.length-1]+1;
//		carry=sum/10;
//		res[digits.length-1]=sum%10;
//		for(int i=digits.length-2;i>=0;i--){
//		    sum = digits[i]+carry;
//			carry=sum/10;
//			res[i]=sum%10;
//		}
//		if(carry==1){
//			int[] newres = new int[digits.length+1];
//			newres[0]=1;
//			for(int i=1;i<digits.length+1;i++){
//				newres[i]=res[i-1];
//			}
//			return newres;
//		}
//		return res;
//        
//    }
}
