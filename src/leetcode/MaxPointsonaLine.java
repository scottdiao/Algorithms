package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
*
* @author Scott
*/
public class MaxPointsonaLine {
    public int maxPoints(Point[] points) {
//       (1,2) (2,4) are in the same line since (2,4)/gcd=(1,2)
        if (points==null) return 0;
        if (points.length<=2) return points.length;
//      Map(x,(y,count))
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        int result=0;
        //以i为起点，计算所有ij线段
        for (int i=0;i<points.length;i++){ 
            map.clear();
            int overlap=0,max=0;
            for (int j=i+1;j<points.length;j++){
                int x=points[j].x-points[i].x;
                int y=points[j].y-points[i].y;
                if (x==0&&y==0){
                    overlap++;
                    continue;
                }
                int gcd=generateGCD(x,y);
                if (gcd!=0){
                    x/=gcd;
                    y/=gcd;
                }

                if (map.containsKey(x)){
                    if (map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }   				
                }else{
                    Map<Integer,Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max=Math.max(max, map.get(x).get(y));
            }
            result=Math.max(result, max+overlap+1); //要加1，因为map的值只是多少个点和i点共线，要加上i点本身
        }
        return result;
    }
    
//    Greatest Common Divisor(GCD)  欧几里德算法
    private int generateGCD(int a,int b){
        if (b==0) return a;
        else return generateGCD(b,a%b);
    }
}
