package com.Graph;
/*克隆一个无向图，无向图如下所示
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
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);	//克隆自身节点
		map.put(clone.label, clone);
		for(UndirectedGraphNode ug : node.neighbors) {	//克隆邻居节点，因为每个邻居节点都对应一组关系，所以需要用递归
			clone.neighbors.add(cloneGraph(ug));
		}
		return clone;
    }
}
