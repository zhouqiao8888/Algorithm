package com.LinkedList;

import java.util.ArrayList;

/*
 * 将k个有序链表融合成一个链表，分析并计算算法复杂度
 *  */
public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if(lists == null || lists.size() <= 0)
			return null;
		ListNode res = lists.get(0);
		int size = lists.size();
		if(size == 1)
			return res;
		for(int i = 1;i < size;i ++) {
			res = mergeTwoLists(res, lists.get(i));
		}
		return res;
	}
	
	public ListNode mergeTwoLists(ListNode head, ListNode head2) {
		if(head == null && head2 == null)
			return null;
		if(head != null && head2 == null)
			return head;
		if(head == null && head2 != null)
			return head2;
		if(head.val < head2.val) {
			head.next = mergeTwoLists(head.next, head2);
			return head;
		}
		else {
			head2.next = mergeTwoLists(head, head2.next);
			return head2;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(5);	
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		
		ListNode head3 = new ListNode(5);
		head3.next = new ListNode(6);
		head3.next.next = new ListNode(7);
		
		ArrayList<ListNode> lists = new ArrayList<ListNode>();	
		lists.add(head);
		lists.add(head2);
		lists.add(head3);
		ListNode res = new MergeKSortedLists().mergeKLists(lists);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
