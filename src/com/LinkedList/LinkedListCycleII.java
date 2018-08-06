package com.LinkedList;
/*
 * Ѱ��һ��������ڽڵ㣬����ʹ�ö���Ŀռ䣬���û�ҵ�������null
 * ���磺1,2,3,4,5,6,3,��ڽڵ���3
 */
public class LinkedListCycleII {
	 public ListNode detectCycle(ListNode head) {
		 if(head == null || head.next == null)	return null;	//�����������ͷ�ڵ㣬����Ϊ�ǻ�				
		 ListNode pFast = head;
		 ListNode pSlow = head;
		 ListNode pMeet = null;
		 while(pFast.next != null && pFast.next.next != null) { 
			 pFast = pFast.next.next;
			 pSlow = pSlow.next;
			 if(pFast == pSlow) {	//����˵�����ڻ������ǲ����������ڵ���ǻ�����ڽڵ�
				 pMeet = pFast;
				 //System.out.println(pMeet.val);
				 break;
			 }
		 }		 
		 //Ѱ�һ�����ڽڵ�
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
