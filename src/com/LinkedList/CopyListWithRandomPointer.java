package com.LinkedList;

//复杂链表的复制
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null || head.next == null)
			return head;;
		//复制常规节点
		RandomListNode copy = head;
		while(copy != null) {
			RandomListNode temp = new RandomListNode(copy.label);
			RandomListNode next = copy.next;
			copy.next = temp;
			temp.next = next;
			copy = next;
		}		
		//复制随机节点
		RandomListNode copy2 = head;
		while(copy2 != null) {
			if(copy2.random != null) {
				copy2.next.random = copy2.random.next;
			}
			copy2 = copy2.next.next;
		}
		//分拆
		RandomListNode copy3 = head;
		RandomListNode res = head.next;
		RandomListNode resTemp = res;
		while(copy3 != null) {
			copy3.next = copy3.next.next;	
			if(resTemp.next != null) {
				resTemp.next = resTemp.next.next;
			}
			copy3 = copy3.next;
			resTemp = resTemp.next;
		}
		return res;
	}
	
	public static void main(String[] args) {
		RandomListNode node = new RandomListNode(1);
		node.next = new RandomListNode(2);
		node.next.next = new RandomListNode(3);
		
		RandomListNode resultNode = new CopyListWithRandomPointer().copyRandomList(node);
		RandomListNode temp = resultNode;
		while(temp != null) {
			System.out.print(temp.label + " ");
			temp = temp.next;
		}
	}
}
