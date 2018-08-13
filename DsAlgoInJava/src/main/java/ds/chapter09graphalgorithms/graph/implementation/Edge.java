package ds.chapter09graphalgorithms.graph.implementation;

public class Edge {
		int vertex;
		int weight;
		
		public Edge(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
		
		public int getVertex(){
			return this.vertex;
		}
		
		public int getWeight(){
			return this.weight;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + vertex;
			result = prime * result + weight;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (vertex != other.vertex)
				return false;
			if (weight != other.weight)
				return false;
			return true;
		}
		
		
}
