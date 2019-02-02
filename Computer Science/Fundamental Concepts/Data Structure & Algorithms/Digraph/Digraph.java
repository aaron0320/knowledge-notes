import java.util.*;

class Digraph {
	private final int V;
	private int E;
	private List<Integer>[] adj;
	
	public Digraph(int V) {
		this.V = V;
		this.adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
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
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public static Digraph reverse(Digraph graph) {
		Digraph newDigraph = new Digraph(graph.V());
		for (int v = 0; v < graph.V(); v++) {
			for (int w : graph.adj(v)) {
				newDigraph.addEdge(w, v);
			}
		}
		return newDigraph;
	}
}