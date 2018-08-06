package com.Tree;
//将一个节点值升序排列的单链表转化成一个二叉排序树
//思路：寻找中间节点（快慢指针），为根节点，对中间节点左右两部分递归即可。
public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null)
	    	return null;
	    if(head.next == null)
	    	return new TreeNode(head.val);
		ListNode slow = head;   //慢指针,最后会指向中间节点
		ListNode fast = head;	
		ListNode preMid = null;	//中间节点的前一个节点
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			preMid = slow;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		preMid.next = null; //截断链表
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}
}
