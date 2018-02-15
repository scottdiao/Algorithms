package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
*
* @author Scott
*/
public class ClosestBinarySearchTreeValueII  {
    public static void main(String[] args) {
         double a =2.000;
         int b=2;
         System.out.println(b==a);
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList();
//         3
//      2     5
//    1     7    20
//             15  23
// target = 15       s1= 1 2 3 5 7  s2=20 23

        Stack<Integer> s1 = new Stack<>(); // predecessors for the target
        Stack<Integer> s2 = new Stack<>(); // successors for the target
//As we know, inorder traversal gives us sorted predecessors, 
//whereas reverse-inorder traversal gives us sorted successors
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);

        while (k-- > 0) {
          if (s1.isEmpty())
            res.add(s2.pop());
          else if (s2.isEmpty())
            res.add(s1.pop());
          else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
            res.add(s1.pop());
          else
            res.add(s2.pop());
        }

        return res;
      }

      // inorder traversal / reverse inorder traversal
      void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if (root == null) return;

        inorder(reverse ? root.right : root.left, target, reverse, stack);
        // early terminate, no need to traverse the whole tree
        if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
        // track the value of current node
        stack.push(root.val);
        inorder(reverse ? root.left : root.right, target, reverse, stack);
    }
}
