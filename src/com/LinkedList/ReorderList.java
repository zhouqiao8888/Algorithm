package com.LinkedList;
/*Given a singly linked list，按如下规则重排 
{1,2,3,4,5}，重排为
{1,5,2,4,3}
思路：找到中间节点3，对其后的链表反转得
1,2,3
5,4
然后重组为1,5,2,4,3
*/
public class ReorderList {
	 public void reorderList(ListNode head) {
		 if(head == null || head.next == null)
			 return;
		 //快慢指针找到中间节点
		 ListNode fastPointer = head;
		 ListNode slowPointer = head;
		 while(fastPointer.next != null && fastPointer.next.next != null) {
			 fastPointer = fastPointer.next.next;
			 slowPointer = slowPointer.next;
		 }
		 //System.out.println(slowPointer.val);
		 
		 //将中间节点后面的链表反转
		 ListNode backHead = slowPointer.next;
		 ListNode pre = backHead;
		 ListNode cur = backHead.next;
		 ListNode next = null;
		 while(cur != null) {
			 next = cur.next;
			 cur.next = pre;
			 pre = cur;
			 cur = next;
		 }
		 backHead.next = null;
		 slowPointer.next = null;	//两个链表分开
		 //System.out.println(pre.val);
		 
		 //融合重组
		 ListNode headBackup = head;
		 while(headBackup != null && pre != null) {
			 ListNode headNext = headBackup.next;
			 ListNode preNext = pre.next;
			 headBackup.next = pre;
			 pre.next = headNext;
			 headBackup = headNext;			
			 pre = preNext;
		 }	 
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
		head.next.next.next = new ListNode(4);	
		head.next.next.next.next = new ListNode(5);	
		
		ReorderList rl = new ReorderList();
		rl.reorderList(head);
		rl.printLinkedList(head);
	}
}
