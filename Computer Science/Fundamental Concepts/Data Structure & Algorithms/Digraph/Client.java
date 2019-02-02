class Client {
	public static void main(String[] args) {
		Digraph graph = new Digraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.printEdges();
//		Digraph reversedGraph = Digraph.reverse(graph);
//		reversedGraph.printEdges();
		
//		DepthFirstOrder dfo = new DepthFirstOrder(graph);
//		System.out.println(dfo.reversePost());
		
		KosarajuSharirSCC scc = new KosarajuSharirSCC(graph);
		System.out.println(scc.stronglyConnected(1, 3));
	}
}