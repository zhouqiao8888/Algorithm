package com.Tree;

import java.util.*;

/*��ɶ�������ָ��任
        1
       /  \
      2    3
     / \  / \
    4  5  6  7
    
        1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if(root == null) 
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		int count = queue.size();	//��¼������ÿһ��Ԫ�صĸ���
		queue.offer(root);		
		List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
		while(!queue.isEmpty()) {
			if(count == 0) {
				count = queue.size();
			}
			
			TreeLinkNode temp = queue.poll();
			if(temp != null) {
				count --;
				list.add(temp);
			}
			
			if(count == 0) {	//����һ����
				connect2(list);
				list.clear();
			}
			
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			
			if(temp.right != null) {
				queue.offer(temp.right);
			}
		}	
    }
	
	public void connect2(List<TreeLinkNode> list) {
		if(list == null)
			return;
		TreeLinkNode pre;
		TreeLinkNode cur;
		for(int i = 0;i < list.size() - 1;i ++) {
			pre = list.get(i);
			cur = list.get(i + 1);
			pre.next = cur;
		}
	}
}
