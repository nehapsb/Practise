package ds.chapter09graphalgorithms.graph.problems;

import ds.chapter09graphalgorithms.graph.implementation.AdjacencyListGraph;
import ds.chapter09graphalgorithms.graph.implementation.AdjacencyMatrixGraph;

public class GraphOperations {

	public static void main(String[] args){
		AdjacencyMatrixGraph adjacencyMatrixGraph  = new AdjacencyMatrixGraph(4);
		adjacencyMatrixGraph.addEdge(0, 1);
		adjacencyMatrixGraph.addEdge(1, 2);
		adjacencyMatrixGraph.addEdge(2, 0);
		adjacencyMatrixGraph.displayGraph();
		adjacencyMatrixGraph.removeEdge(2, 0);
		System.out.println("----------------------");
		adjacencyMatrixGraph.displayGraph();
		
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(4);
		adjacencyListGraph.addEdge(0, 1);
	//	adjacencyListGraph.addEdge(0, 2);
		adjacencyListGraph.addEdge(1, 2);
		adjacencyListGraph.addEdge(2, 0);
		System.out.println("Adjacency list");
		adjacencyListGraph.displayList();
	}
}
