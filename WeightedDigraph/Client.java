class Client {
	public static void main(String[] args) {
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
		graph.addEdge(new DirectedEdge(0, 1, 5));
		graph.addEdge(new DirectedEdge(0, 4, 9));
		graph.addEdge(new DirectedEdge(0, 7, 8));
		graph.addEdge(new DirectedEdge(1, 2, 12));
		graph.addEdge(new DirectedEdge(1, 3, 15));
		graph.addEdge(new DirectedEdge(1, 7, 4));
		graph.addEdge(new DirectedEdge(2, 3, 3));
		graph.addEdge(new DirectedEdge(2, 6, 11));
		graph.addEdge(new DirectedEdge(3, 6, 9));
		graph.addEdge(new DirectedEdge(4, 5, 4));
		graph.addEdge(new DirectedEdge(4, 6, 20));
		graph.addEdge(new DirectedEdge(4, 7, 5));
		graph.addEdge(new DirectedEdge(5, 2, 1));
		graph.addEdge(new DirectedEdge(5, 6, 13));
		graph.addEdge(new DirectedEdge(7, 5, 6));
		graph.addEdge(new DirectedEdge(7, 2, 7));
		
		int s = 0;
//		SP sp = new DijkstraSP(graph, s);
		SP sp = new AcyclicSP(graph, s);
		for (int v = 0; v < graph.V(); v++) {
			System.out.printf("%d to %d (%.2f): ", s, v, sp.distTo(v));
			System.out.println();
			for (DirectedEdge e : sp.pathTo(v)) {
				System.out.println(e.from() + "-" + e.to());
			}
		}
	}
}