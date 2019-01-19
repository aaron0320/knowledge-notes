import java.util.*;

class EdgeWeightedDigraph {
	private final int V;
	private final List<DirectedEdge>[] adj;
	private int E;
	
	public EdgeWeightedDigraph(int V) {
		this.V = V;
		adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<DirectedEdge>();
		}
	}
	
	public int V() {
		return V;
	}
	
	private int E() {
		return E;
	}
	
	public void addEdge(DirectedEdge e) {
		int v = e.from();
		adj[v].add(e);
		E++;
	}
	
	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}
}