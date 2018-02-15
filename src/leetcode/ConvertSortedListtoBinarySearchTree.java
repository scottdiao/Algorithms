package leetcode;

//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//
//Example:
//
//Given the sorted linked list: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5

public class ConvertSortedListtoBinarySearchTree  {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        //注意边界问题， 第二个参数是exclusive
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
    
    
    //GIPlan
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return binarySearch(head,null);
    }
    
    public TreeNode binarySearch(ListNode head, ListNode tail){
        ListNode slow = head, fast = head;
        if(head==tail) return null;
        while(fast!=tail&&fast.next!=tail){
            slow =slow.next;
            fast=fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = binarySearch(head , slow);
        node.right = binarySearch(slow.next,tail);
        return node;
    }
}
