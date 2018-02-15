package leetcode;

//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//Return a deep copy of the list.


import java.util.HashMap;
import java.util.Map;

/**
*
* @author Scott
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
	RandomListNode iter = head, next;
        

	// First round: make copy of each node,
	// and link them together side-by-side in a single list.
        // 1-2-3-4  1-1-2-2-3-3-4-4
	while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;

            iter = next;
	}                                                                             

	// Second round: assign random pointers for the copy nodes.
	iter = head;
	while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
	}

	// Third round: restore the original list, and extract the copy list.
	iter = head;
	RandomListNode pseudoHead = new RandomListNode(0);
	RandomListNode copy, copyIter = pseudoHead;

	while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
	}

	return pseudoHead.next;
    }
    
    
    // Easy way but need extra space
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        //  key为原始Node  值为复制node
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
          map.put(node, new RandomListNode(node.label));
          node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
          map.get(node).next = map.get(node.next);
          map.get(node).random = map.get(node.random);
          node = node.next;
        }

        return map.get(head);
      }
    
}
