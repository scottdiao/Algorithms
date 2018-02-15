package leetcode;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//For example:
//Given the following binary tree,
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//You should return [1, 3, 4].


public class BinaryTreeRightSideView {

    public static void main(String[] args) {
          TreeNode a = new TreeNode(1);
          TreeNode b = new TreeNode(2);
          a.left = b;
          set(a,2);
          System.out.println(a.val);
          System.out.println(b.val);
    }
    
//    The core idea of this algorithm:
//
//1.Each depth of the tree only select one node.
//
//View depth is current size of result list.
    
    //先访问右子树的dfs
	
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }

}
