package Algorithms;

public class QuikSort {
    //自己改版的快排非常漂亮
    public static void main(String[] args) {
        int[] a = new int[]{1,15,5,19,6,88,79,85,42,22};
        quickSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
	
    public static void quickSort(int[] num,int p,int r){
        if(p<r){
            int q = partition(num,p,r);
            quickSort(num,p,q-1);
            quickSort(num,q+1,r);
        }
    }

    public static int partition(int[] num, int p, int r){
        int x = num[r];
        int i=p;
        for(int j=p;j<r;j++){
            if(num[j]<=x){
                swap(num,  i,  j);
                i++;
            }
        }
        swap(num,  i,  r);
        return i;
    }
    
    private static void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
