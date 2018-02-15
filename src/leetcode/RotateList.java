package leetcode;

public class RotateList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        System.out.println(6%3);
        rotateRight(a,0);
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
       if(head==null||head.next==null) return head;
       int len=1;
       ListNode cur = head, tail=head;
       while(tail.next!=null){
           tail=tail.next;
           len++;
       }
       if(k%len==0) return head; //这么做的缺点就是必须得判断
       cur = head;
       for(int i=1;i<len-k%len;i++){
           cur=cur.next;
       }
       ListNode newHead = cur.next;
       cur.next=null;
       tail.next=head;
       return newHead;
    }
    
//    public static ListNode rotateRight(ListNode head, int n) {
//        if (head==null||head.next==null) return head;
//        ListNode dummy=new ListNode(0);
//        dummy.next=head;
//        ListNode fast=dummy,slow=dummy;
//
//        int i;
//        for (i=0;fast.next!=null;i++)//Get the total length 
//            fast=fast.next;
//        System.out.println("n:"+n);
//        System.out.println("i:"+i);
//        System.out.println("n%i"+n%i);
//        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
//            slow=slow.next;
//        System.out.println("slow:"+slow.val);
//        System.out.println("fast:"+fast.val);
//        fast.next=dummy.next; //Do the rotation
//        dummy.next=slow.next;
//        slow.next=null;
//
//        return dummy.next;
//    }
    
    
    
    
    

//	public static void main(String[] args) {
//		ListNode a = new ListNode(1);
//		ListNode b = new ListNode(2);
//		ListNode c = new ListNode(3);
//		ListNode d = new ListNode(4);
//		ListNode e = new ListNode(5);
//		a.next=b;
//		b.next=c;
//		c.next=d;
//		d.next=e;
//		System.out.println(getlen(a));
//		System.out.println(getk(a,2,0,getlen(a)).val);
//	}
	
//	 public static ListNode rotateRight(ListNode head, int k) {
//		 int len=getlen(head);
//		 
//		 if(k<=0||head==null||len<2||k%len==0){
//			 return head;
//		 }
//		 k = k % len;
//		 if(k==len){
//		     return head;
//		 }
//	        ListNode node=getk(head,k,0,getlen(head));
//	        ListNode temp = node.next;
//	        node.next=null;
//	        if(temp.next==null){
//	        	temp.next=head;
//	        	return temp;
//	        }
//	        ListNode temp2=getk(temp, 1, 0, getlen(temp));
//	        temp2.next.next=head;
//	        
//	        return temp;
//	    }
//	 
//	
//	public static ListNode getk(ListNode node, int k, int record, int len){
//		if(node==null){
//			return new ListNode(0);
//		}
//		record++;
//		if(len-record==k){
//			return node;
//		}
//		
//		return getk(node.next,k,record, len);
//	}
//	public static int getlen(ListNode node){
//		if(node==null){
//			return 0;
//		}
//		return getlen(node.next)+1;
//	}

}
