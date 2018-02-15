package leetcode;

import java.util.HashMap;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
//
//For example, given
//
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7


/**
*
        _______7______
       /              \
    __10__          ___2
   /      \        /
   4       3      _8
            \    /
             1  11
*/
//preorder = {7,10,4,3,1,2,8,11}
//inorder = {4,10,3,1,7,11,8,2}
//postorder={4,3,1,10,11,8,2,7}
//postorder 必须用four pointer因为要记录postStart和postEnd
// inorder的4,10,3,1为左子树，同样为Postorder 4,3,1,10
public class ConstructBinaryTreefromInorderandPostorderTraversal  {
    static int i=0;
    public static void main(String[] args){
        int[] a = {2,1};
        int[] b = {2,1};
        System.out.println(buildTree(a,b));
    }
     public static TreeNode buildTree(int[] inorder, int[] postorder) {
         return helper(0,postorder.length-1, 0, inorder.length - 1, postorder, inorder);
    }
     public static TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
         System.out.println("iteration:"+i);
         System.out.println("postStart:"+postStart);
         System.out.println("inStart:"+inStart);
         System.out.println("inEnd:"+inEnd);
         if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(postStart, postStart + inIndex - inStart -1, inStart, inIndex - 1, postorder, inorder);
        root.right = helper(postEnd - postStart + inIndex, postEnd-1, inIndex + 1, inEnd, postorder, inorder);
        return root;
    }
     
     
     // Hashmap caching
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
	for (int i=0;i<inorder.length;++i){
            hm.put(inorder[i], i);
        }
        return helper(0, postorder.length-1,0,inorder.length-1,postorder,inorder, hm);
    }
    public TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder, HashMap<Integer, Integer> hm){
        if(postStart>postEnd||inStart>inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index =  hm.get(postorder[postEnd]);

        //一定要在inStart和inEnd中间遍历， 而且要包括instart和inEnd
 
        root.left = helper(postStart, postStart + (index-inStart) -1 , inStart, index-1, postorder, inorder, hm);
        //Key! 就是preStart的位移是index - inStart
        root.right= helper(postStart + (index-inStart), postEnd-1, index+1, inEnd, postorder, inorder, hm);
        return root;
    }
}
