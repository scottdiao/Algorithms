
import leetcode.ListNode;

/**
*
* @author Scott
*/
public class ReverseLinkedList {
     public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 一定要注意返回到底是啥，一开始我写的返回的cur,那最终时Null啊、

        return pre;
    }
}
