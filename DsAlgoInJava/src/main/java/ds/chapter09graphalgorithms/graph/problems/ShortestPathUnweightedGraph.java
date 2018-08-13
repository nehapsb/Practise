package ds.chapter09graphalgorithms.graph.problems;

import java.awt.geom.Path2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import ds.chapter09graphalgorithms.graph.implementation.AdjacencyListGraph;
import ds.chapter09graphalgorithms.graph.traversals.BreadthFirstTraversal;

public class ShortestPathUnweightedGraph {

	public int[] findShorttestPathInUnweightedGraph(BreadthFirstTraversal graph, int vertex){
		Queue<Integer> queue = new LinkedList<Integer>();
		int vertexCount = graph.getVertexCount();
		LinkedList<Integer>[] edges = graph.getEdges();
		int[] distance = new int[vertexCount] ;
		int[] path = new int[vertexCount] ;
		int v= 0;
		
		queue.add(vertex);
		
		for(int i = 0; i<vertexCount; i++){
			distance[i] = -1;
		}
		distance[vertex] = 0;
		
		while(!queue.isEmpty()){
			v = queue.poll();
			
			Iterator<Integer> i = edges[v].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(distance[n] == -1){
					distance[n] = distance[v] +1;
				}
				path[n] = v;
			}
		}
		return distance;
	}
	
	public static void main(String args[])
    {
        BreadthFirstTraversal g = new BreadthFirstTraversal(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        
        ShortestPathUnweightedGraph shortestPathUnweightedGraph = new ShortestPathUnweightedGraph();
        int[] dist =   shortestPathUnweightedGraph.findShorttestPathInUnweightedGraph(g, 0);
        for(int i =0 ;i<dist.length; i++){
        	System.out.println(dist[i]);
        }
        
    }
}
