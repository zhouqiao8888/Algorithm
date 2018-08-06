package com.LinkedList;
//将两个有序链表合并成一个链表
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			return null;
		}
		
		if(l1 == null && l2 != null) {
			return l2;
		}
		
		if(l1 != null && l2 == null) {
			return l1;
		}
		
		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(5);	
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(52);
		
		ListNode res = new MergeTwoSortedLists().mergeTwoLists(head, head2);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
