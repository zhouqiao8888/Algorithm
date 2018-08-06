package com.LinkedList;
/*
 * ����һ�������������������ڵ㣬�������1->2->3->4
 * ����2->1->4->3. 
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;
		//ͳ������ĳ���
		ListNode temp = head;
		int len = 0;
		while(temp != null) {
			len ++;
			temp = temp.next;
		}
		//�ֶη�ת����
		ListNode fake = new ListNode(-1);
		fake.next = head;
		ListNode pre = fake;
		ListNode cur = head;
		ListNode next = null;
		for(int i = 0;i < len / 2;i ++) {  //�ܹ���Ҫ��ת���ٶ�
			for(int j = 1;j < 2;j ++) {  //ÿһ�εķ�ת����
				next = cur.next;
				cur.next = next.next;
				next.next = pre.next;
				pre.next = next;
			}
			pre = cur;
			cur = cur.next;
		}
		return fake.next;    
	}
	
	public static void main(String[] args) {
		SwapNodesInPairs r = new SwapNodesInPairs();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		ListNode res = r.swapPairs(l1);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
