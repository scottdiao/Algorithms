package leetcode;
/**
*
* @author Scott
*/
public class ConstructtheRectangle  {
     public static void main(String[] args) {
         System.out.println((int)Math.sqrt(23));
        }
    

    
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
	while (area%w!=0) w--;
	return new int[]{area/w, w};
    }
}
