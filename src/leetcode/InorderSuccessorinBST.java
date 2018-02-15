package leetcode;


import leetcode.TreeNode;

/**
*
* @author Scott
*/
public class InorderSuccessorinBST {

    // Hard to understand
    public TreeNode successor(TreeNode root, TreeNode p) {
      if (root == null)
        return null;
      if (root.val <= p.val) {
        return successor(root.right, p);
      } else {
        TreeNode left = successor(root.left, p);
        return (left != null) ? left : root;
      }
    }
    
    
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
          return null;

        if (root.val >= p.val) {
          return predecessor(root.left, p);
        } else {
          TreeNode right = predecessor(root.right, p);
          return (right != null) ? right : root;
        }
      }
    
    // easy version
     public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
          return null;
        // case1: if p has right node, find the min in tight chiladren
        if(p.right!=null) return findMin(p.right);
        
        // case2: find p's ancessor, make sure p is ancestor's left node
        TreeNode ancestor = root;
        TreeNode successor = null;
        while(ancestor!=p){
            if(p.val<ancestor.val){
                successor = ancestor;
                ancestor=ancestor.left;
            }else{
                ancestor=ancestor.right;
            }
        }
        return successor;
     }
        
    private TreeNode findMin(TreeNode node){
        if (node.left==null) return node;
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
      
      
    
}
