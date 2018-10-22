import java.util.*;

class Graph {
	private final int V;
	private int E;
	private List<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		this.adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0 ; i < V; i++) {
			this.adj[i] = new LinkedList<Integer>();
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void printEdges() {
		for (int v = 0; v < V(); v++) {
			for (int w : adj(v)) {
				System.out.println(v + "-" + w);
			}
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public static int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v)) degree++;
		return degree;
	}
	
	public static int maxDegree(Graph G) {
		int max = 0;
		for (int v = 0; v < G.V(); v++) {
			int degree = degree(G, v);
			if (degree > max) max = degree;
		}
		return max;
	}
	
	public static double avgDegree(Graph G) {
		return 2.0 * G.E() / G.V();
	}
	
	public static int numOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
				}
			}
		}
		return count / 2;
	}
}