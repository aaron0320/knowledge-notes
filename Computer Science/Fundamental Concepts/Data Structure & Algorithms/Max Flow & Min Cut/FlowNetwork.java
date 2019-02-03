import java.util.*;

class FlowNetwork {
	private final int V;
	private LinkedList<FlowEdge>[] adj;
	private int E;
	
	public FlowNetwork(int V) {
		this.V= V;
		adj = (LinkedList<FlowEdge>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<FlowEdge>();
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public LinkedList<FlowEdge> adj(int v) {
		return adj[v];
	}
	
	public void addEdge(FlowEdge e) {
		adj[e.from()].add(e);
		adj[e.to()].add(e);
		E++;
	}
}