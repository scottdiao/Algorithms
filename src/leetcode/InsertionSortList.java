package leetcode;


//Sort a linked list using insertion sort.
//插入排序的精髓，将当前未排序元素插入到已经排好序的合适位置

public class InsertionSortList  {
    // in array insertion sort, we have to shift the array, but in linked list we only need to insert the node
    // to the correct position
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }
        //一定要注意，由于helper是新的head，不能一开始就连上现在的list
        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
           
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
}   
}
