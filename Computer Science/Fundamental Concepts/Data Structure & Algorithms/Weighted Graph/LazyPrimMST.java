import java.util.*;

class LazyPrimMST {
	private final LinkedList<Edge> mst;
	
	private final BinaryHeapMinPQ<Edge> pq;
	private final boolean[] marked;
	
	public LazyPrimMST(EdgeWeightedGraph G) {
		mst = new LinkedList<Edge>();
		pq = new BinaryHeapMinPQ<Edge>(G.E());
		marked = new boolean[G.V()];
		
		visit(G, 0);
		
		while(!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			
			if (marked[v] && marked[w]) continue;
			mst.add(e);
			if (!marked[v]) visit(G, v);
			if (!marked[w]) visit(G, w);
		}
	}
	
	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			if (!marked[w]) {
				pq.insert(e);
			}
		}
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}
}