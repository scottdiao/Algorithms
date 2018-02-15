package leetcode;

public class RemoveNthNodeFromEndofList {
    
        public static void main(String[] args) {
            ListNode test = new ListNode(1);
	}
        
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;
            // Advances first pointer so that the gap between first and second is n nodes apart
            for (int i = 1; i <= n + 1; i++) {
                first = first.next;
            }
            // Move first to the end, maintaining the gap
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }
        
        // Two pass
//	public static ListNode removeNthFromEnd(ListNode head, int n) {
//            if(head==null){
//                return null;
//            }
//            int l = 1;
//            ListNode temp = head;
//            ListNode dummyHead = new ListNode(0);
//            dummyHead.next = head;
//            temp = head;
//            while(temp.next!=null){
//                 temp = temp.next;
//                 l++;
//            }
//            temp = dummyHead;
//            System.out.println("long"+l);
//            for(int i=0;i<l-n;i++){
//                temp= temp.next;
//            }
//            temp.next = temp.next.next;
//            
//            return dummyHead.next;
//        }
}
