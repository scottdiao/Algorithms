package leetcode;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(mySqrt(2147483647));

	}
	public static int mySqrt(int x) {
            if (x < 0)
                return -1;
            if (x <= 1)
                return x;
            int low = 1, high = x;
            while (low <=high) {
                int mid = low + (high - low) / 2;
                if (mid == x/mid)
                    return mid;
                else if (mid < x/mid)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return high;
        }
        
        // Integer Newton
        public static int mySqrt(int x) {
            long r = x;
            while (r*r > x)
                r = (r + x/r) / 2;
            return (int) r;
        }
        
//      GIPlan
        public static int mySqrt(int x) {
            if (x < 0)
                return -1;
            if (x <= 1)
                return x;
            int low=0, high=x;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(mid<x/mid) low = mid+1;
                else if(mid>x/mid) high = mid-1;
                else return mid;
            }
            return high;
        }

}
