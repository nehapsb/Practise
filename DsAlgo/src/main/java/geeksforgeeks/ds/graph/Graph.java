package geeksforgeeks.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
  private int V;
  private LinkedList<Integer> adj[];
  Graph(int V) {
    this.V=V;
    adj = new LinkedList[V];
    for(int i=0; i< V; i++) {
        adj[i]=new LinkedList<Integer>();
    }
  }
  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public void bfs(int source) {
    boolean visited[] = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    visited[source] = true;
    queue.add(source);
    while(!queue.isEmpty()) {
      source = queue.poll();
      System.out.print(source+" ");

      Iterator<Integer> i = adj[source].listIterator();
      while(i.hasNext()) {
        int n = i.next();
        if(!visited[n]) {
          visited[n]=true;
          queue.add(n);
        }
      }

    }
    System.out.println("");
  }
  public void dfs(int source) {
    boolean visited[] = new boolean[V];
    for(int i=0;i<V;i++) {
      if(!visited[i]) {
        dfsUtil(source, visited);
      }
    }
    System.out.println("");
  }
  private void dfsUtil(int source, boolean[] visited) {
    visited[source]=true;
    System.out.print(source+" ");
    Iterator<Integer> i = adj[source].iterator();
    while(i.hasNext()) {
      int n = i.next();
      if(!visited[n]) {
        dfsUtil(n, visited);
      }
    }
  }

  public static void main (String[] args) {
    /**
     *       0 ----> 1
     *      ^ \      /
     *      /  \    |
     *      |   |  /
     *      |   / /
     *      \  < <
     *         2 ----->3-
     *                 ^|
     *                 ||
     *                  -
     */
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.bfs(2);
    g.dfs(2);

  }

}
