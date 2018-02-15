package leetcode;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
                ListNode c = new ListNode(3);
                ListNode d = new ListNode(4);
		a.next=b;
                b.next=c;
                c.next=d;
                swapPairs(a);
		
	}
        
        public static ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode current = dummy;
            int i =0;
            while (current.next != null && current.next.next != null) {

                ListNode first = current.next;
                ListNode second = current.next.next;
//                  current: 0-1-2-3-4 
//                  first:   1-2-3-4
//                  second:  2-3-4
                
                first.next = second.next;
//                 current: 0-1-3-4 
//                 first: 1-3-4
//                 second: 2-3-4
                
                current.next = second;
//                current: 0-2-3-4
//                first: 1-3-4
//                second 2-3-4
                

                current.next.next = first;
//                current: 0-2-1-3-4
//                first:  1-3-4
//                second: 2-1-3-4
                
//                if(i==0){
//                    ListNode print = current;
//                    while(print!=null){
//                        System.out.println("current"+print.val);
//                        print=print.next;
//                    }
//                    print = first;
//                    while(print!=null){
//                        System.out.println("first"+print.val);
//                        print=print.next;
//                    }
//                    print = second;
//                    while(print!=null){
//                        System.out.println("second"+print.val);
//                        print=print.next;
//                    }
//                }
                current = current.next.next;
//                i++;
            }
            return dummy.next;
        }
        
//        public ListNode swapPairs(ListNode head) {
//            if ((head == null)||(head.next == null))
//                return head;
//            ListNode n = head.next;
////            1-3-5-7-9
//            head.next = swapPairs(head.next.next);
//            n.next = head;
//            return n;
//        }
    
//	public ListNode swapPairs(ListNode head) {
//            if(head==null||head.next==null){
//                return null;
//            }
//            return swap(head);
//        }
//
//        public ListNode swap(ListNode head){
//            if(head==null||head.next==null){
//                return null;
//            }
//            ListNode temp = new ListNode(0);
//
//            temp=head.next;
//            head.next=head.next.next;
//            temp.next=head;
//            temp.next.next = swap(head.next);
//
//            return temp;
//        }

}
