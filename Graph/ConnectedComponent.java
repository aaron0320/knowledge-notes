class ConnectedComponent {
	private boolean marked[];
	private int[] id;
	private int ccCount;
	
	public ConnectedComponent(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				ccCount++;
			}
		}
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = ccCount;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	public int count() {
		return ccCount;
	}
	
	public int id(int v) {
		return id[v];
	}

}