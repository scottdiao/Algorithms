package ots;
import java.io.Serializable;

// Given am array a[n], all number is less than n-1 , find the first duplicate number

public class FirstDuplicateInArray {
   
 
    /* Driver program to test the above function */
    public static void main(String[] args) {
        int arr[] = {-4, -2, -4, -5, 2, 3, 1};
        printRepeating(arr);
        printFirstDuplicate(arr);
    }
    
     public static void  printRepeating(int[] arr){
        int i;  
        System.out.println("The repeating elements are : ");
    
        for (i = 0; i < arr.length; i++){
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }         
    } 
     
     public static void  printFirstDuplicate(int[] arr){
        int i;  
        for (i = 0; i < arr.length; i++){
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else{
                System.out.println("first duplicate"+arr[i]);
                return;
            }
        }       
    } 
}
