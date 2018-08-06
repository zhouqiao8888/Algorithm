package com.LinkedList;
/*删除链表中重复的元素（重复的元素不保留）
 *Given1->2->2->3->3->4->4->5, return1->2->5.
 *Given1->1->1->2->3, return2->3. 
 */
public class RemoveDuplicatesFromSortedListII {
	//递归解法
	public ListNode deleteDuplicates(ListNode head) {
	    if(head == null || head.next == null)
	    	return head;
	    ListNode newHead = head;
	    ListNode cur = head.next;
	    while(cur != null && newHead.val == cur.val) { //直到找到不重复的元素头	    	
		    while(cur != null && newHead.val == cur.val) { 
		    	cur = cur.next;
		    }	
		    if(cur == null) { //找到最后仍然没找到不一样的元素头
			    return null;
		    }
		    else {
		    	newHead = cur;
		    }
		    cur = cur.next; //找到之后仍然要对这个新的元素头进行判断，是否符合要求
	    }	   
    	newHead.next = deleteDuplicates(newHead.next);
    	return newHead;    
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);		
		head.next.next.next = new ListNode(3);	
		head.next.next.next.next = new ListNode(2);	
		head.next.next.next.next.next = new ListNode(4);	
		ListNode res = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
