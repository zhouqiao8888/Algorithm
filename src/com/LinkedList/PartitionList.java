package com.LinkedList;
/*分割链表
 * Given1->4->3->2->5->2and x = 3,
 * return1->2->2->4->3->5. 小于x的放前面（原顺序不变），大于等于x的放后面（原顺序不变）
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null)
			return head;
		ListNode pre = new ListNode(0);
		ListNode back = new ListNode(0);
		ListNode preCur = pre;
		ListNode backCur = back;
		while(head != null) {
			if(head.val < x) {
				preCur.next = head;
				preCur = preCur.next;
			}
			else {
				backCur.next = head;
				backCur = backCur.next;
			}
			head = head.next;
		}
		preCur.next = back.next;
		backCur.next = null;
		return pre.next;	
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);		
		head.next.next.next = new ListNode(2);	
		head.next.next.next.next = new ListNode(5);	
		head.next.next.next.next.next = new ListNode(2);	
		new PartitionList().partition(head, 3);
		ListNode res = new PartitionList().partition(head, 3);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
