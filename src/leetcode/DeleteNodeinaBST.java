package leetcode;
/**
*
* @author Scott
*/
public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        //Once the node is found, have to handle the below 4 cases
        }else{
            //node doesn't have left or right - return null
//            node only has left subtree- return the left subtree
//            node only has right subtree- return the right subtree
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
//node has both left and right - find the minimum value in the right subtree, 
//set that value to the currently found node, then recursively delete the minimum value 
//in the right subtree
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            // we need to delete the origin one
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
