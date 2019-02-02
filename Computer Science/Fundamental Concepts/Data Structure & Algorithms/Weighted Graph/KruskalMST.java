import java.util.*;

class KruskalMST {
	private List<Edge> mst = new LinkedList<Edge>();
	
	public KruskalMST(EdgeWeightedGraph G) {
		BinaryHeapMinPQ<Edge> pq = new BinaryHeapMinPQ<Edge>(G.E());
		for (Edge e : G.edges()) {
			pq.insert(e);
		}
			
		QuickUnionUF uf = new QuickUnionUF(G.V());
		
		while(!pq.isEmpty() && 
			mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (!uf.connected(v, w)) {
				mst.add(e);
				uf.union(v, w);
			}
		}
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}
}