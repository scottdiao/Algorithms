package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Scott
*/
public class FindLargestValueinEachTreeRow  {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        dfs(root.left, res, d+1);
        dfs(root.right, res, d+1);
    }
}
