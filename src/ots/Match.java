package ots;
/**
*
* @author Scott
*/
public class Match  {
    public static void main(String[] args){
        MakeTheNumbersMatch(55,31, 26, 15);
    }
    public static void MakeTheNumbersMatch(int a, int b, int x, int y)
        {
        while(a!=x || b!=y){
            if(a> x)
            {
                a--;
            }
            else if(a<x)
            {
                a++;
            }
            if(b>y)
            {
                b--;
            }
            else if(b<y)
            {
                b++;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(x);
        System.out.println(y);
    }
}
