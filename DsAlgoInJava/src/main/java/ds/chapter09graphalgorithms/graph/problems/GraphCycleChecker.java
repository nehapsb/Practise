package ds.chapter09graphalgorithms.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter03linkedlist.singlylinkedlist.ListNode;
import ds.chapter09graphalgorithms.graph.implementation.AdjacencyListGraph;
import ds.chapter09graphalgorithms.graph.traversals.BreadthFirstTraversal;

public class GraphCycleChecker {

	public boolean isCyclic(AdjacencyListGraph graph){
		boolean iscyclic = false;
		int vertexCount = graph.getVertexCount();
		boolean visited[] = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<Integer>();
        ds.chapter03linkedlist.singlylinkedlist.LinkedList[] edges = graph.getEdges();
        visited[0] = true;
        queue.add(0);
        int w = 0;
        while(queue.size() != 0){
        	int s = queue.poll();
        	System.out.println("s " +s);
        	ListNode head = edges[s].getHead();
        	while(head.getNext() != null){
        		w = head.getData();
        		if(!visited[w]){
        			visited[w] = true;
        			queue.add(w);
        		}else{
        			iscyclic = true;
        		}
        		head = head.getNext();
        	}
        }
		return iscyclic;
	}
	
	
	public static void main(String args[])
    {
        AdjacencyListGraph g = new AdjacencyListGraph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
      //  g.addEdge(1, 2);
        //g.addEdge(2, 0);
        g.addEdge(2, 3);
     //   g.addEdge(3, 3);
        g.displayList();
       
        GraphCycleChecker cycleChecker = new GraphCycleChecker();
        System.out.println("Is Cyclic " +cycleChecker.isCyclic(g));
    }
}
