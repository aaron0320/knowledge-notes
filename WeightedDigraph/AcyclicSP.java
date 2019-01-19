import java.util.*;

class AcyclicSP extends SP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	
	public AcyclicSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0;
		
		TopologicalSort tsort = new TopologicalSort(G, s);
		for (Integer v : tsort.order()) {
			for (DirectedEdge e : G.adj(v)) {
				relax(e);
			}
		}
	}
	
	private void relax(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		System.out.println("relax " + v + "-" + w);
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}
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

}