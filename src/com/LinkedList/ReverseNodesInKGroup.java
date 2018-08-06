package com.LinkedList;
/*ÿ��k��ֵ������ת����ʣ�µĳ��Ȳ���k���򲻷�ת
 * ��������1->2->3->4->5 
 * k = 2, ��2->1->4->3->5 
 * k = 3, ��3->2->1->4->5 
 * ����ⷨ�ο�ReverseLinkedListII
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k < 2)
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
		for(int i = 0;i < len / k;i ++) {  //�ܹ���Ҫ��ת���ٶ�
			for(int j = 1;j < k;j ++) {  //ÿһ�εķ�ת����
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
		ReverseNodesInKGroup r = new ReverseNodesInKGroup();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		ListNode res = r.reverseKGroup(l1, 3);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
