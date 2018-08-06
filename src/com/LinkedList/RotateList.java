package com.LinkedList;
/*旋转链表
 Given1->2->3->4->5->NULL and k =2,
 return4->5->1->2->3->NULL. 
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n <= 0)
			return head;
		//统计链表长度
		int count = 1;
		ListNode pre = head; //指向链表最后一个节点
		ListNode cur = head.next;
 		while(cur != null) {
 			pre = pre.next;
			cur = cur.next;
			count ++;
		}
 		n = n % count;  //n的长度可能大于count,因此要对count取余
 		if(n == 0) //不旋转
 			return head;
		else {
			ListNode h1 = head;
			int count1 = 1;
			while(count1 < count - n) { //等于时跳出
				count1 ++;
				h1 = h1.next;
			}
			ListNode h2 = h1.next; //后半部分的头节点
			h1.next = null;
			pre.next = head;
			return h2;
		}	
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);		
//		head.next.next.next = new ListNode(4);	
//		head.next.next.next.next = new ListNode(5);	
		ListNode res = new RotateList().rotateRight(head, 2);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
