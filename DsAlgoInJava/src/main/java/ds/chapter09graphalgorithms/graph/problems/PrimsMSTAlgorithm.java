package ds.chapter09graphalgorithms.graph.problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class PrimsMSTAlgorithm {

	public void primsMST(int graph[][], int vertexCount){
		//Array to store constructed MST
		int[] parent = new int[vertexCount];
		 // Key values used to pick minimum weight edge in cut
		
		//PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		
		int[] key = new int[vertexCount];
		
		// To represent set of vertices not yet included in MST
		boolean[] mstSet = new boolean[vertexCount];
		
		for(int i = 0; i < vertexCount; i++){
			mstSet[i] = false;
			key[i] = Integer.MAX_VALUE;
		}
	//	priorityQueue.add(0);
		key[0] = 0;
		parent[0] = -1;
		
		for(int count = 0; count < vertexCount; count++){
			//int min = priorityQueue.poll();
			int min = minKey(key, mstSet, vertexCount);
			mstSet[min] = true;
			
			for(int v = 0; v<vertexCount; v++){
				if(graph[min][v] != 0 && mstSet[v]== false && graph[min][v] < key[v]){
					parent[v] = min;
					key[v] = graph[min][v];
				}
			}
			
		}
		printMST(parent, vertexCount, graph);
	}
	
	int minKey(int key[], boolean mstSet[], int vertexCount)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < vertexCount; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
 
	 void printMST(int parent[], int vertexCount, int graph[][])
	    {
	        System.out.println("Edge   Weight");
	        for (int i = 1; i < vertexCount; i++)
	            System.out.println(parent[i]+" - "+ i+"    "+
	                               graph[i][parent[i]]);
	    }
	 
	
	public static void main(String[] args){
		PrimsMSTAlgorithm primsMSTAlgorithm = new PrimsMSTAlgorithm();
		int graph[][] = new int[][] {{0, 2, 0, 6, 0},
									 {2, 0, 3, 8, 5},
									 {0, 3, 0, 0, 7},
									 {6, 8, 0, 0, 9},
									 {0, 5, 7, 9, 0},
							};
		primsMSTAlgorithm.primsMST(graph, 5);
		
		/*PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10);
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		//...

		Integer val = null;
		while( (val = queue.poll()) != null) {
		    System.out.println(val);
		}*/
	}
}
