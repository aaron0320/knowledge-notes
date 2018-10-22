class Client {
	public static void main(String[] args) {
		Digraph graph = new Digraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.printEdges();
//		Digraph reversedGraph = Digraph.reverse(graph);
//		reversedGraph.printEdges();
		
		DepthFirstOrder dfo = new DepthFirstOrder(graph);
		System.out.println(dfo.reversePost());
	}
}