package ds.chapter09graphalgorithms.graph.traversals;

import java.util.LinkedList;
import java.util.Stack;

import ds.chapter09graphalgorithms.graph.implementation.AdjacencyMatrixGraph;

public class DepthFirstTraversal {

	private int vertices;   // No. of vertices
	private int adjMatrix[][]; //Adjacency Lists
 
    // Constructor
    DepthFirstTraversal(int v)
    {
        vertices = v;
        this.adjMatrix = new int[vertices][vertices];
       
    }
 
    // Function to add an edge into the graph
    void addEdge(int i,int j)
    {
    	if(i >= 0 && i < this.vertices && j >= 0 && j < this.vertices){
			adjMatrix[i][j] = 1;
			adjMatrix[j][i] = 1; //For undirected graph both way it will be 1.
		}
    }
    
	public void dfs(){
		Stack<Integer> stack = new Stack<Integer>();
		boolean [] vertexList = new boolean[vertices ];
		vertexList[0] = true;
		//System.out.println(0);
		stack.push(0);
		while(!stack.isEmpty()){
			int v = getAdjUnvisitedVertex(stack.peek(), vertexList);
			//System.out.println(" " + v);
			if(v == -1){
			int s =	stack.pop();
			System.out.println(s);
			}
			else{
				vertexList[v] = true;
				stack.push(v);
			}
		}
		
		for(int i = 0; i<vertices; i++){
			vertexList[i] = false;
		}
	}

	private int getAdjUnvisitedVertex(Integer v, boolean[] vertexList ) {
		for(int j = 0; j<vertices; j++){
			if(adjMatrix[v][j] == 1 && vertexList[j] == false){
				return j;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		DepthFirstTraversal depthFirstTraversal = new DepthFirstTraversal(4);
		depthFirstTraversal.addEdge(0, 1);
		depthFirstTraversal.addEdge(0, 2);
		depthFirstTraversal.addEdge(1, 2);
		depthFirstTraversal.addEdge(2, 0);
		depthFirstTraversal.addEdge(3, 0);
	//	depthFirstTraversal.displayGraph();
		depthFirstTraversal.dfs();
	}
}
