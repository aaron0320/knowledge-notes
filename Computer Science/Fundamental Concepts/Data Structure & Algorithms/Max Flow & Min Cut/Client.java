class Client {
	public static void main(String[] args) {
		FlowNetwork graph = new FlowNetwork(8);
		graph.addEdge(new FlowEdge(0, 1, 10));
		graph.addEdge(new FlowEdge(0, 2, 5));
		graph.addEdge(new FlowEdge(0, 3, 15));
		graph.addEdge(new FlowEdge(1, 2, 4));
		graph.addEdge(new FlowEdge(2, 3, 4));
		graph.addEdge(new FlowEdge(1, 4, 9));
		graph.addEdge(new FlowEdge(2, 5, 8));
		graph.addEdge(new FlowEdge(3, 6, 16));
		graph.addEdge(new FlowEdge(1, 5, 15));
		graph.addEdge(new FlowEdge(6, 2, 6));
		graph.addEdge(new FlowEdge(4, 5, 15));
		graph.addEdge(new FlowEdge(5, 6, 15));
		graph.addEdge(new FlowEdge(4, 7, 10));
		graph.addEdge(new FlowEdge(5, 7, 10));
		graph.addEdge(new FlowEdge(6, 7, 10));
		
		FordFulkerson ff = new FordFulkerson(graph, 0, 7);
		System.out.println("Flow Value = " + ff.value());
		for (int v = 0; v < graph.V(); v++) {
			System.out.println(v + " in cut? " + ff.inCut(v));
		}
	}
}