package ds.chapter09graphalgorithms.graph.traversals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import ds.chapter09graphalgorithms.graph.implementation.AdjacencyListGraph;

public class BreadthFirstTraversal {

	private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    
    // Constructor
    public BreadthFirstTraversal(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
    }
 
    // Function to add an edge into the graph
    public void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
	
    public int getWeight(int source, int destination){
		return 0;
    }
    public int getVertexCount(){
    	return V;
    }
    public LinkedList<Integer>[] getEdges(){
    	return adj;
    }
    
    public void displayList(){
		for(int i = 0; i<V; i++){
			System.out.println("adjacency list of vertex " + i);
			System.out.println(adj[i].toString());
			System.out.println("");
		}
	}
	public void bfs(int s){
		boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        
        visited[s] = true;
        queue.add(s);
        
        while(queue.size() != 0){
        	s = queue.poll();
        	System.out.println("s " +s);
        	Iterator<Integer> i = adj[s].listIterator();
        	while(i.hasNext()){
        		int n = i.next();
        	//	System.out.println(" not visited " +n + " " + visited[n]);
        		if(!visited[n]){
        		//	System.out.println("n not visited");
        			visited[n] = true;
        			queue.add(n);
        		}
        	}
        }
	}
	
	
	public static void main(String args[])
    {
        BreadthFirstTraversal g = new BreadthFirstTraversal(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.displayList();
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.bfs(2);
    }
}
