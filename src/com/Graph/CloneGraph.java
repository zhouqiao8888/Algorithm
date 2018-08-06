package com.Graph;
/*��¡һ������ͼ������ͼ������ʾ
 *  1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */
import java.util.*;
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}
public class CloneGraph {
	HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		if(map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);	//��¡����ڵ�
		map.put(clone.label, clone);
		for(UndirectedGraphNode ug : node.neighbors) {	//��¡�ھӽڵ㣬��Ϊÿ���ھӽڵ㶼��Ӧһ���ϵ��������Ҫ�õݹ�
			clone.neighbors.add(cloneGraph(ug));
		}
		return clone;
    }
}
