package com.LinkedList;
/*删除链表中重复的元素（重复的元素只保留一个）
 *Given1->1->2->3->3, return1->2->3. 
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
	    if(head == null || head.next == null)
	    	return head;
	    ListNode pre = head;
	    ListNode cur = head.next;
	    while(cur != null) {
	    	if(pre.val == cur.val) { //直到找到不重复的元素
	    		cur = cur.next;
	    		continue;
	    	}
	    	pre.next = cur;
	    	pre = pre.next;
	    	cur = cur.next;
	    }
	    pre.next = null;
	    return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);		
		head.next.next.next = new ListNode(3);	
		head.next.next.next.next = new ListNode(3);	
		head.next.next.next.next.next = new ListNode(4);	
		ListNode res = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
