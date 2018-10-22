import java.util.*;

class BreadthFirstPath {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private int s;
	
	public BreadthFirstPath(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		Arrays.fill(distTo, -1);
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(Graph G, int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		marked[v] = true;
		distTo[v] = 0;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for (int w : G.adj(node)) {
				if (!marked[w]) {
					queue.add(w);
					marked[w] = true;
					edgeTo[w] = node;
					distTo[w] = distTo[node] + 1;
				}
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
	
	public int distTo(int v) {
		return distTo[v];
	}
}