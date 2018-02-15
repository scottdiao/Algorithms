package leetcode;

import java.util.Random;

/**
*
* @author Scott
*/
public class LinkedListRandomNode  {
    ListNode head;
    Random random;
    
    public LinkedListRandomNode(ListNode head) {
        this.head = head;                
    }
    
    public int getRandom() {
        
        ListNode c = head;
        int r = c.val;
        for(int i=1;c.next != null;i++){
            c = c.next;
            if(randInt(0,i) == i) r = c.val;                        
        }
        
        return r;
    }
    
    private static int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    
    public static void main(String[] args){
        System.out.println(randInt(0, 3));
    }
}
