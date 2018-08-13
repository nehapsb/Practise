package ds.chapter09graphalgorithms.graph.problems;

import ds.chapter03linkedlist.singlylinkedlist.ListNode;
import ds.chapter07priorityqueuesandheaps.priorityqueue.implementation.MinHeap;
import ds.chapter09graphalgorithms.graph.implementation.AdjacencyListGraph;
import ds.chapter09graphalgorithms.graph.implementation.Edge;

public class DijkstraShortestPathAlgorithm {

	public void dijkstraAlgorithm(AdjacencyListGraph graph, int vertex){
		int vertexCount = graph.getVertexCount();
		MinHeap priorityQueue = new MinHeap(vertexCount);
		int[] distance = new int[vertexCount] ;
		int[] path = new int[vertexCount] ;
		ds.chapter03linkedlist.singlylinkedlist.LinkedList[] edges = graph.getEdges();
		int v, w = 0;
		priorityQueue.insert(vertex);
		
		for(int i =0; i<vertexCount; i++){
			distance[i] = -1;
		}
		distance[vertex] = 0;
		
		while(!priorityQueue.isEmpty()){
			v = priorityQueue.deleteMin();
			
			//Iterator<Integer> i = edges[v].listIterator();
			ListNode head = edges[v].getHead();
			System.out.println("head " + head.getData());
			while(head.getNext() != null){
				w = head.getData();
				int newDistance = distance[v] + graph.getAdjacencyWeights(v).getWeight();
				
				if(distance[w] == -1){
					distance[w] = newDistance;
					priorityQueue.insert(w);
					path[w] = v;
				}
				if(distance[w] > newDistance){
					distance[w] = newDistance;
					//update the distance in priority queue to new distance
					path[w] = v;
				}
				head = head.getNext();
				
			}
		}
		printSolution(distance, vertexCount);
	}
	void printSolution(int dist[],  int V)
	{
	   System.out.println("Vertex   Distance from Source\n");
	   for (int i = 0; i < V; i++)
		   System.out.println( i + "   " + dist[i]);
	}
	public static void main(String[] args){
		DijkstraShortestPathAlgorithm  dijkstraShortestPathAlgorithm = new DijkstraShortestPathAlgorithm();
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(5);
		adjacencyListGraph.addEdge(0, new Edge(1, 1));
		adjacencyListGraph.addEdge(0, new Edge(2, 4));
		adjacencyListGraph.addEdge(1, new Edge(4, 4));
		adjacencyListGraph.addEdge(2, new Edge(1, 2));
		adjacencyListGraph.addEdge(2, new Edge(3, 4));
		adjacencyListGraph.addEdge(3, new Edge(4, 4));
		dijkstraShortestPathAlgorithm.dijkstraAlgorithm(adjacencyListGraph, 1);
		
		
	}
}
