import java.util.*;

class FordFulkerson {
	private boolean[] marked;
	private FlowEdge[] edgeTo;
	private double value = 0.0;
	
	public FordFulkerson(FlowNetwork G, int s, int t) {
		while (hasAugmentingPath(G, s, t)) {
			// Find bottleneck value
			double bottleneck = Double.POSITIVE_INFINITY;
			for (int v = t; v != s; v = edgeTo[v].other(v)) {
				bottleneck = Math.min(bottleneck, edgeTo[v].residualCapacityTo(v));
			}
			
			// Update graph with bottleneck value
			for (int v = t; v != s; v = edgeTo[v].other(v)) {
				edgeTo[v].addResidualFlowTo(v, bottleneck);
			}
			
			// Update flow value
			value += bottleneck;
		}
	}
	
	private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
		marked = new boolean[G.V()];
		edgeTo = new FlowEdge[G.V()];
		
		// Shortest Path(BFS) approach is used here, consider using fattest path approach instead for low capacity
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		marked[s] = true;
		
		while (!queue.isEmpty() && !marked[t]) {
			int v = queue.remove();
			for (FlowEdge e : G.adj(v)) {
				int w = e.other(v);
				if (!marked[w] && e.residualCapacityTo(w) > 0) {
					marked[w] = true;
					edgeTo[w] = e;
					queue.add(w);
				}
			}
		}
		return marked[t];
	}
	
	public double value() {
		return value;
	}
	
	public boolean inCut(int v) {
		return marked[v];
	}
}