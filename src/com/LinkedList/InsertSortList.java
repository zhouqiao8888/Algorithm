package com.LinkedList;

public class InsertSortList {
	public ListNode insertSort(ListNode head) {
		if(head == null || head.next == null)	return head;		
		ListNode fakeNode = new ListNode(-1);
		fakeNode.next = head;
		ListNode pre = head;	//前后两个指针用于比较前后两个数的大小
		ListNode cur = head.next;
		while(pre.next != null) {
			if(pre.val < cur.val) {	//不用插入，指针右移
				pre = pre.next;
				cur = cur.next;
			}
			else {
				ListNode cur2 = cur;	//将要插入节点剥离出来
				cur = cur.next;	
				pre.next = cur;				
				
				//从前往后找，找到第一个比cur2大的节点，插到它的后面
				ListNode temp = fakeNode;
				while(temp.next.val < cur2.val) {
					temp = temp.next;
				}
				ListNode temp2 = temp.next;
				temp.next = cur2;
				cur2.next = temp2;
			}
		}		
		return fakeNode.next;
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
		
		InsertSortList is = new InsertSortList();
		ListNode mergeNode = is.insertSort(head2);
		is.printLinkedList(mergeNode);
	}
}
