package ds.chapter09graphalgorithms.graph.implementation;

public class AdjacencyMatrixGraph {

	private int adjMatrix[][];
	private int vertexCount;
	
	public AdjacencyMatrixGraph(int vertexCount){
		this.vertexCount = vertexCount;
		this.adjMatrix = new int[vertexCount][vertexCount];
	}
	
	public void addEdge(int i, int j){
		if(i >= 0 && i < this.vertexCount && j >= 0 && j < this.vertexCount){
			adjMatrix[i][j] = 1;
			adjMatrix[j][i] = 1; //For undirected graph both way it will be 1.
		}
	}
	
	public void removeEdge(int i, int j){
		if(i >= 0 && i < this.vertexCount && j >= 0 && j < this.vertexCount){
			adjMatrix[i][j] = 0;
			adjMatrix[j][i] = 0;
		}
	}
	
	public boolean isEdge(int i, int j){
		boolean isEdge = false;
		if(i >= 0 && i < this.vertexCount && j >= 0 && j < this.vertexCount){
			if(adjMatrix[i][j] == 1 && adjMatrix[j][i] == 1){
				isEdge = true;
			}
		}
		return isEdge;
	}
	
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
	
	public int getVertexCount() {
		return vertexCount;
	}
	
	public void displayGraph(){
		for(int i =0; i<adjMatrix.length; i++){
			for(int j=0; j<adjMatrix.length; j++){
				System.out.print( " " +adjMatrix[i][j] + " ");
			}
			System.out.println( );
		}
	}
}
