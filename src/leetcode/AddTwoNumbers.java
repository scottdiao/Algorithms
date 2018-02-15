package leetcode;
import java.io.Serializable;
/**
*
* @author Scott
*/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
    // GIPlan 
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        ListNode p = l1, q = l2;
        int carry =0;
        while(p!=null||q!=null){
            int sum = 0, x=0,y=0;
            if(p!=null){
                x = p.val;
                p=p.next;
            }
            if(q!=null){
                y = q.val;
                q=q.next;
            }
            sum = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }
        if(carry>0){
            curr.next = new ListNode(1);
        }
        
        return dummyHead.next;
    }
}
