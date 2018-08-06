package com.LinkedList;
/*
 * 寻找一个环的入口节点，不能使用额外的空间，如果没找到，返回null
 * 例如：1,2,3,4,5,6,3,入口节点是3
 */
public class LinkedListCycleII {
	 public ListNode detectCycle(ListNode head) {
		 if(head == null || head.next == null)	return null;	//若链表仅存在头节点，不认为是环				
		 ListNode pFast = head;
		 ListNode pSlow = head;
		 ListNode pMeet = null;
		 while(pFast.next != null && pFast.next.next != null) { 
			 pFast = pFast.next.next;
			 pSlow = pSlow.next;
			 if(pFast == pSlow) {	//相遇说明存在环，但是不代表相遇节点就是环的入口节点
				 pMeet = pFast;
				 //System.out.println(pMeet.val);
				 break;
			 }
		 }		 
		 //寻找环的入口节点
		 if(pMeet != null) {
			 ListNode pStart = head;
			 while(pMeet != null && pStart != null) {
				 if(pMeet == pStart) {
					 return pMeet;
				 }
				 pMeet = pMeet.next;
				 pStart = pStart.next;
			 }
		 }
		 return null;
	 }
	 
	 public static void main(String[] args) {
			ListNode p1 = new ListNode(1);
			ListNode p2 = new ListNode(2);
			ListNode p3 = new ListNode(3);
			ListNode p4 = new ListNode(4);
			ListNode p5 = new ListNode(5);
			ListNode p6 = new ListNode(6);
			p1.next = p2;
			p2.next = p3;
			p3.next = p4;
			p4.next = p5;
			p5.next = p6;
			p6.next = p3;
			
			LinkedListCycleII lc = new LinkedListCycleII();
			ListNode res = lc.detectCycle(p1);
			if(res != null) {
				System.out.println(res.val);
			}
		}
}
