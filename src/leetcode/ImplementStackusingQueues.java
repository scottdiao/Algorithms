package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
*
* @author Scott
*/
public class ImplementStackusingQueues  {
    private Queue<Integer> q;
    
    public MyStack() {
        q = new LinkedList();
    }

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        //很重要的queue自旋技巧，注意如果size为i只需循环i-1次
        for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
            q.add(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
    
}
