package ds.chapter09graphalgorithms.graph.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class AdjacencyListGraph {
	
	private ArrayList<Integer> vertices;
	private LinkedList<Integer>[] edges;
	
	Map<Integer, Edge> adjacencyWeights = new HashMap<Integer, Edge>();
	public LinkedList<Integer>[] getEdges() {
		return edges;
	}

	private int vertexCount;
	
	public int getVertexCount() {
		return vertexCount;
	}

	public AdjacencyListGraph(int vertexCount){
		this.vertexCount = vertexCount;
		vertices = new ArrayList<Integer>();
		edges = new LinkedList[vertexCount];
		
		for (int i =0; i< this.vertexCount; i++){
			vertices.add(i);
			edges[i] = new LinkedList();
			
		}
	}
	
	public void addEdge(int source, int destination){
		System.out.println("vertices " + vertices);
		int i = vertices.indexOf(source);
		int j = vertices.indexOf(destination);
		
		System.out.println("i "+ i + " j"+ j);
		if( i != -1 || j != -1){
			edges[i].insertAtEnd(new ListNode(destination));
			edges[j].insertAtEnd(new ListNode(source));
		}
	}
	
	public void addEdge(int source, Edge destination){
		int i = vertices.indexOf(source);
		int j = vertices.indexOf(destination.getVertex());
		
		if( i != -1 || j != -1){
			edges[i].insertAtEnd(new ListNode(destination.getVertex()));
			adjacencyWeights.put(source, destination);
		}
	}
	
	public Edge getAdjacencyWeights(int key) {
		for(Map.Entry<Integer, Edge> entry : adjacencyWeights.entrySet()){
			System.out.println("vertex " + entry.getKey());
			System.out.println("edge " + entry.getValue().getVertex() + " weight " + entry.getValue().getWeight());
		}
		return adjacencyWeights.get(key);
	}

	public void removeEdge(int source, int destination){
		int i = vertices.indexOf(source);
		int j = vertices.indexOf(destination);
		
		if( i != -1 || j != -1){
			edges[i].removeFromBegin();
			edges[j].removeFromBegin();
		}
	}
	
	public boolean isEdge(int source, int destination){
		int i = vertices.indexOf(source);
		int j = vertices.indexOf(destination);
		
		if( i != -1 || j != -1){
			//edges[i].getLength()
		}
		return false;
	}
	
	public void displayList(){
		for(int i = 0; i<vertices.size(); i++){
			System.out.println("adjacency lst of vertex " + i);
			System.out.println(edges[i].toString());
			System.out.println("");
		}
	}
}

