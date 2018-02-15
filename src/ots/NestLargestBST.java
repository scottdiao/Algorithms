package ots;
/**
*
* @author Scott
*/
public class NestLargestBST  {
    static int res = -1;
    static int dif = Integer.MAX_VALUE;
    public static void main(String[] args){
//        BST 1 2 3 5 7 9 10
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(9);
        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(3);
        a.left = b;
        b.left = f;
        b.right= g;
        a.right = c;
        c.right = e;
        e.right = d;
        System.out.println(nextLargest(a,5));
        
    }
    public static int nextLargest(TreeNode root, int target){
        if(root==null) return res;
        if(root.val>target) {
            if((root.val-target)<dif){
                dif = root.val-target;
                res = root.val;
            } 
            return(nextLargest(root.left, target));
        }else{
            return(nextLargest(root.right, target));
        }
    }
}
