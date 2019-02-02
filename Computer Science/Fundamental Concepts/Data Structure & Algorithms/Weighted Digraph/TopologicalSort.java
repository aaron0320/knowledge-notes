import java.util.*;

class TopologicalSort {
	private boolean[] marked;
	private Deque<Integer> order;
	
	public TopologicalSort(EdgeWeightedDigraph G, int s) {
		marked = new boolean[G.V()];
		order = new ArrayDeque<Integer>();
		dfs(G, s);
	}
	
	private void dfs(EdgeWeightedDigraph G, int v) {
		marked[v] = true;
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		order.push(v);
	}
	
	public Iterable<Integer> order() {
		return order;
	}
}