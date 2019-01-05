class KosarajuSharirSCC {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public KosarajuSharirSCC(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder dfs = new DepthFirstOrder(Digraph.reverse(G));
		for (int v : dfs.reversePost()) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}
	
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
}