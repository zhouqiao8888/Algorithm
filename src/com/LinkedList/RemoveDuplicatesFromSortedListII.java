package com.LinkedList;
/*ɾ���������ظ���Ԫ�أ��ظ���Ԫ�ز�������
 *Given1->2->2->3->3->4->4->5, return1->2->5.
 *Given1->1->1->2->3, return2->3. 
 */
public class RemoveDuplicatesFromSortedListII {
	//�ݹ�ⷨ
	public ListNode deleteDuplicates(ListNode head) {
	    if(head == null || head.next == null)
	    	return head;
	    ListNode newHead = head;
	    ListNode cur = head.next;
	    while(cur != null && newHead.val == cur.val) { //ֱ���ҵ����ظ���Ԫ��ͷ	    	
		    while(cur != null && newHead.val == cur.val) { 
		    	cur = cur.next;
		    }	
		    if(cur == null) { //�ҵ������Ȼû�ҵ���һ����Ԫ��ͷ
			    return null;
		    }
		    else {
		    	newHead = cur;
		    }
		    cur = cur.next; //�ҵ�֮����ȻҪ������µ�Ԫ��ͷ�����жϣ��Ƿ����Ҫ��
	    }	   
    	newHead.next = deleteDuplicates(newHead.next);
    	return newHead;    
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);		
		head.next.next.next = new ListNode(3);	
		head.next.next.next.next = new ListNode(2);	
		head.next.next.next.next.next = new ListNode(4);	
		ListNode res = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
