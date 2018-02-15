package ots;
/**
*
* @author Scott
*/
public class reverseFibonacci  {
    public static void main(String[] args){
        reverseFibonacci(55,31);
    }
    public static void reverseFibonacci(int a, int b){
        if(a<b||a<0||b<0) System.out.println("not valid");
        else{
            System.out.println(a);
            System.out.println(b);
            while(a-b>=0){
                int temp = a - b;
                System.out.println(temp);
                if(temp==0) break;
                a = b;
                b = temp;
            }
        }
    }
}
