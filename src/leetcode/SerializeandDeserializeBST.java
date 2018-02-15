package leetcode;

import java.util.LinkedList;

/**
*
* @author Scott
*/
public class SerializeandDeserializeBST  {
    // preorder serialize 
    public String serialize(TreeNode root) {
	if (root == null) {
	    return "#!";
	}
	String res = root.val + "!";
	res += serialize(root.left);
	res += serialize(root.right);
	return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] strings = data.split("!");
    	LinkedList<String> list = new LinkedList<>();
    	for (String string:strings){
    	    list.add(string);
    	}
        return reconPreOrder(list);
    }
    
    public TreeNode reconPreOrder(LinkedList<String> queue){
    	String val = queue.poll();
    	if (val.equals("#")) {
    	    return null;
	}
    	TreeNode head = new TreeNode(Integer.valueOf(val));
    	head.left = reconPreOrder(queue);
    	head.right = reconPreOrder(queue);
    	return head;
    }
}
