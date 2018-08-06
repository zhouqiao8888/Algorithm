package com.Tree;
//��һ���ڵ�ֵ�������еĵ�����ת����һ������������
//˼·��Ѱ���м�ڵ㣨����ָ�룩��Ϊ���ڵ㣬���м�ڵ����������ֵݹ鼴�ɡ�
public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null)
	    	return null;
	    if(head.next == null)
	    	return new TreeNode(head.val);
		ListNode slow = head;   //��ָ��,����ָ���м�ڵ�
		ListNode fast = head;	
		ListNode preMid = null;	//�м�ڵ��ǰһ���ڵ�
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			preMid = slow;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		preMid.next = null; //�ض�����
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}
}
