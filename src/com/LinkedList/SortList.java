package com.LinkedList;


//对一单链表排序：时间复杂度O(nlogn)
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class SortList {
	//单链表的归并排序
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode middle = getMiddleNode(head);
		ListNode back = middle.next;
		middle.next = null;
		return mergeList(sortList(head), sortList(back));
	}
	
	public ListNode getMiddleNode(ListNode head) {
		if(head == null || head.next == null)
			return head;
		//定义快慢指针
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		while(fastPointer.next != null && fastPointer.next.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		return slowPointer;
	}
	
	public ListNode mergeList(ListNode head, ListNode head2) {
		if(head == null && head2 == null)
			return null;
		if(head != null && head2 == null)
			return head;
		if(head == null && head2 != null)
			return head2;
		
		ListNode node = null;
		if(head.val < head2.val) {
			node = head;
			node.next = mergeList(head.next, head2);
		}
		else {
			node = head2;
			node.next = mergeList(head, head2.next);
		}
		return node;
	}
	
	public void printLinkedList(ListNode node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);		
		ListNode head2 = new ListNode(3);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(4);
		
		SortList sl = new SortList();
		ListNode mergeNode = sl.sortList(head2);
		sl.printLinkedList(mergeNode);
	}
}
