package leetcode;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

public class PathSumII {

    public static void main(String[] args) {

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        if(root==null){
            return res;
        }
        dfs(root,sum,res,path);
        return res;
    }
    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
        path.add(root.val);
        if(root.val==sum&&root.left==null&&root.right==null){
            res.add(new ArrayList(path));
        }
        sum-=root.val;
        if(root.left!=null){
            dfs(root.left, sum, res, path);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            dfs(root.right, sum, res, path);
            path.remove(path.size()-1);
        }
    }
}
