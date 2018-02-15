package leetcode;

public class RotateList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ListNode rotateRight(ListNode head, int k) {
	    if (head == null || k <= 0)
	        return head;

	    ListNode tail = head;
	    int len = 1;//
	    while (tail.next != null) {// 计算表长并找到尾结点，使其next域指向第一个节点
	        len++;
	        tail = tail.next;
	    }
	    tail.next = head;//
	    k = k % len;// k可能是比链表长度要大的数字，因此实际旋转的位置就是k%len;
	    ListNode p = head;
	    for (int i = 0; i < len - k - 1; i++)
	        p = p.next; // 找到第n-k个结点

	    head = p.next;// 断链
	    p.next = null;
	    return head;

	}

}
