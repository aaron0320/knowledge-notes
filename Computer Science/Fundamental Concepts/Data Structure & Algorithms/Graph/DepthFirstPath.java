import java.util.*;

class DepthFirstPath {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DepthFirstPath(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack<Integer>();
		
		int currentNode = v;
		while (currentNode != s) {
			path.push(currentNode);
			currentNode = edgeTo[currentNode];
		}
		path.push(s);
		
		return path;
	}
}