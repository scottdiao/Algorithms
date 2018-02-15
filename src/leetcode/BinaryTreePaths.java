package leetcode;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        a.left=b;
        a.right=c;
        b.right =d;
        System.out.println(String.valueOf(1).length());
    }
    
   
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) dfs(root, "", answer);
        return answer;
    }
    private void dfs(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) dfs(root.left, path + root.val + "->", answer);
        if (root.right != null) dfs(root.right, path + root.val + "->", answer);
    }

	 

}
