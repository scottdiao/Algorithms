package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Scott
*/
public class ExpressionAddOperators  {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        dfs(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void dfs(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                dfs(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                dfs(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                dfs(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                dfs(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}
