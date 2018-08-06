package com.LinkedList;
/*
 * ����һ������ɾ����������n���ڵ㣬����������� 1->2->3->4->5��n=2
 * ��1->2->3->5.����һ�α������
 * ˼·���������ָ���ҵ�������n���ڵ㣬Ȼ���ٶ���һ��ǰ���ڵ㣬��������n���ڵ�ɾ��
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n <= 0)
			return null;
		ListNode fastNode = head;
		ListNode slowNode = head;
		ListNode fake = new ListNode(-1);
		fake.next = head;  //��ָ���ǰ���ڵ�
		int count = 0;
		while(fastNode != null) {	//���ָ���ȶ���n��
			fastNode = fastNode.next;
			count ++;
			if(count == n) 
				break;
		}
		if(fastNode == null) {	//˵����Ҫɾ����һ���ڵ�
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
