package com.LinkedList;
/*ɾ���������ظ���Ԫ�أ��ظ���Ԫ��ֻ����һ����
 *Given1->1->2->3->3, return1->2->3. 
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
	    if(head == null || head.next == null)
	    	return head;
	    ListNode pre = head;
	    ListNode cur = head.next;
	    while(cur != null) {
	    	if(pre.val == cur.val) { //ֱ���ҵ����ظ���Ԫ��
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
