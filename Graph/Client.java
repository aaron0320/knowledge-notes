class Client {
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
//		graph.addEdge(0, 0);
		
//		System.out.println(graph.adj(0));
//		System.out.println(graph.adj(1));
//		System.out.println(graph.adj(2));
//		System.out.println(graph.adj(3));
//		graph.printEdges();
		
//		System.out.println(Graph.degree(graph, 0));
//		System.out.println(Graph.maxDegree(graph));
//		System.out.println(Graph.avgDegree(graph));
//		System.out.println(Graph.numOfSelfLoops(graph));
		
//		DepthFirstPath dfs = new DepthFirstPath(graph, 0);
//		System.out.println(dfs.pathTo(1));
//		System.out.println(dfs.pathTo(2));
//		System.out.println(dfs.pathTo(3));
		
//		BreadthFirstPath bfs = new BreadthFirstPath(graph, 0);
//		System.out.println(bfs.pathTo(1));
//		System.out.println(bfs.pathTo(2));
//		System.out.println(bfs.pathTo(3));
		
		ConnectedComponent cc = new ConnectedComponent(graph);
		System.out.println(cc.count());
		System.out.println(cc.id(2));
	}
}