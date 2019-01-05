import java.util.*;

class EdgeWeightedGraph {
	private final int V;
	private final LinkedList<Edge>[] adj;
	private final List<Edge> edges;
	
	public EdgeWeightedGraph(int V) {
		this.V = V;
		adj = (LinkedList<Edge>[]) new LinkedList[V];
		edges = new ArrayList<Edge>();
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		
		edges.add(e);
	}
	
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}
	
	public Iterable<Edge> edges() {
		return edges;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return edges.size();
	}
	
	public void printEdges() {
		for (Edge e : edges) {
			int v = e.either();
			int w = e.other(v);
			System.out.println(v + "-" + w + " " + e.weight());
		}
	}
}