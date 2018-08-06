package com.LinkedList;

/*给定一个单链表，将m~n的部分链表反转，其中1 <= m <= n <= len
*Given1->2->3->4->5->NULL, m = 2 and n = 4, 
*先变成1->3->2->4->5->NULL
 return1->4->3->2->5->NULL. 
*/
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        //找到第m个节点和它的前驱节点
		ListNode fake = new ListNode(-1);
		fake.next = head;
		ListNode pre = fake;
		ListNode cur = head;
		for(int i = 1;i < m;i ++) {
			pre = cur;
			cur = cur.next;
		}		
		//反转，反转次数是n-m次
		ListNode next = null;
		for(int i = 1;i <= n - m;i ++) {
			next = cur.next;
			cur.next = next.next;
			next.next = pre.next;
			pre.next = next;
		}
		return fake.next;
    }
	
	public static void main(String[] args) {
		ReverseLinkedListII r = new ReverseLinkedListII();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(3);
//		l1.next.next.next = new ListNode(4);
//		l1.next.next.next.next = new ListNode(5);
		ListNode res = r.reverseBetween(l1, 1, 2);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
