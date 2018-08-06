package com.LinkedList;
/*
 * 给定一个链表，删除它倒数第n个节点，例如给定链表 1->2->3->4->5，n=2
 * 得1->2->3->5.尽量一次遍历完成
 * 思路：定义快慢指针找到倒数第n个节点，然后再定义一个前驱节点，将倒数第n个节点删掉
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n <= 0)
			return null;
		ListNode fastNode = head;
		ListNode slowNode = head;
		ListNode fake = new ListNode(-1);
		fake.next = head;  //慢指针的前驱节点
		int count = 0;
		while(fastNode != null) {	//令快指针先多走n步
			fastNode = fastNode.next;
			count ++;
			if(count == n) 
				break;
		}
		if(fastNode == null) {	//说明是要删除第一个节点
			fake.next = head.next;
			return fake.next;
		}
		else {
			while(fastNode != null) {
				fastNode = fastNode.next;
				slowNode = slowNode.next;
				fake = fake.next;
			}
			fake.next = slowNode.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);		
		head.next.next.next = new ListNode(4);	
		head.next.next.next.next = new ListNode(5);	
		ListNode res = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 6);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
