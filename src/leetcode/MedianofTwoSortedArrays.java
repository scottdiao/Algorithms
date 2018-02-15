package leetcode;

public class MedianofTwoSortedArrays {

    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m+n;
        if (total%2 != 0)
            return (double) findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
        else {
            double x = findKth(A, 0, m-1, B, 0, n-1, total/2);//k传得是第k个，index实则k-1
            double y = findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
            return (double)(x+y)/2;
        }
    }
     
    public static int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        
        if(m>n)
            return findKth(B,bstart,bend,A,astart,aend,k);
        if(m==0)
            return B[k-1];
        if(k==1)
            return Math.min(A[astart],B[bstart]);
        
        int partA = Math.min(k/2,m);
        int partB = k - partA;
        if(A[astart+partA-1] < B[bstart+partB-1])
            return findKth(A,astart+partA,aend,B,bstart,bend,k-partA);
        else if(A[astart+partA-1] > B[bstart+partB-1])
            return findKth(A,astart,aend,B,bstart+partB,bend,k-partB);
        else
            return A[astart+partA-1];
        }
}
        
        
//	public static int randomSelect(int[] num,int p,int r,int i){
//            if(p==r){
//                return num[p];
//            }
//            int q=(int)Math.round(Math.random()*(r-p));
//            int k=q-p+1;
//
//            if(k==i){
//                return num[k];
//            }else if(k>i){
//                return randomSelect(num,p,q-1,i);
//            }else{
//                return randomSelect(num,q+1,r,i);
//            }
//	}
//	
//	public static int randomPartition(int[] num, int p, int r){
//		int i=(int)Math.round(Math.random()*(r-p));
//		int temp = num[r];
//		num[r]=num[i];
//		num[i]=temp;
//		int x =num[r];
//		i=p-1;
//		for(int j=p;j<r;j++){
//			if(num[j]<=x){
//                            i++;
//                            temp=num[i];
//                            num[i]=num[r];
//                            num[r]=temp;
//			}
//		}
//		temp=num[i+1];
//		num[i+1]=num[r];
//		num[r]=temp;
//		return i+1;
//	}

}
