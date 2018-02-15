package leetcode;
/**
*
* @author Scott
*/
//Actually this is a denary tree (each node has 10 children). Find the kth element is to do a k steps preorder traverse of the tree.
public class KthSmallestinLexicographicalOrder  {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }
    //use long in case of overflow
//    how to calculate the steps between curr and curr + 1?
//    Here we come up a idea to calculate by level.
//    Let n1 = curr, n2 = curr + 1.
//     n2 is always the next right node beside n1's right most node (who shares the same ancestor "curr")
//    (refer to the pic, 2 is right next to 1, 20 is right next to 19, 200 is right next to 199).
//
//    so, if n2 <= n, what means n1's right most node exists, we can simply add the number of nodes from n1 to n2 to steps.
//
//    else if n2 > n, what means n (the biggest node) is on the path between n1 to n2, add (n + 1 - n1) to steps.
//
//                                                                                                                                                                                                                                                                                                                                                                              organize this flow to "steps += Math.min(n + 1, n2) - n1; n1 *= 10; n2 *= 10;"
    public int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
