package leetcode;

import java.util.Iterator;
import java.util.List;

/**
*
* @author Scott
*/
public class Vector2D implements Iterator<Integer>  {
    int indexList, indexEle;
    List<List<Integer>> vec; 
    
    public Vector2D(List<List<Integer>> vec2d) {
        indexList = 0;
        indexEle = 0;
        vec = vec2d;
    }

    @Override
    public int next() {
        return vec.get(indexList).get(indexEle++);
    }

    @Override
    // since while(hasNext), do the indexList++ 
    public boolean hasNext() {
        while(indexList < vec.size()){
            if(indexEle < vec.get(indexList).size())
                return true;
            else{
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }
}
