import java.util.*;

// TODO - Only supports ONE negative cycle
class BellmanFordSP extends SP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private ArrayList<DirectedEdge> negativeCycle;
	
	public BellmanFordSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		 
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		edgeTo[s] = null;
		distTo[s] = 0;
		
		// Run Bellman-Ford
		/** TODO - Consider replacing isChanged flag by list of relaxed vertices in Iteration i
		** So that to we only need to check the corresponding edges in Iteration i+1
		**/
		boolean isChanged = false;
		for (int i = 0; i < G.V(); i++) {
			isChanged = false;
			for (int v = 0; v < G.V(); v++) {
				for (DirectedEdge e : G.adj(v)) {
					if (relax(e)) {
						// In iteration V, detect negative cycle 
						if (i == G.V() - 1) {
							findNegativeCycle(G, e);
							return;
						} else { // In iteration 1 to V-1, update isChanged flag
							isChanged = true;
						}
					}
				}
			}
			if (!isChanged)
				break;
		}
	}
	
	private boolean relax(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			return true;
		}
		return false;
	}
	
	@Override
	public double distTo(int v) {
		return distTo[v];
	}
	
	@Override
	public Iterable<DirectedEdge> pathTo(int v) {
		Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			stack.push(e);
		}
		return stack;
	}
	
	boolean hasNegativeCycle() {
		return negativeCycle != null;
	}
	
	Iterable<DirectedEdge> negativeCycle() {
		return negativeCycle;
	}
	
	private void findNegativeCycle(EdgeWeightedDigraph G, DirectedEdge e) {
		/** TODO - Consider creating a new data structure which 
		** - Support O(logN) search, based on Edge ID
		** - Support O(logN+R) range delete, based on push order **/
		negativeCycle = new ArrayList<DirectedEdge>();
		
		while(true) {
			if (negativeCycle.contains(e)) {
				// Remove all edges, except cycle edges
				int i = negativeCycle.indexOf(e);
				negativeCycle.subList(0, i).clear();
				break;
			} else {
				// Back traverse edges until negative cycle is found
				negativeCycle.add(e);
				e = edgeTo[e.from()];
			}
		}
	}
}