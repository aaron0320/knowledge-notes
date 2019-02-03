class FlowEdge {
	private final int v;
	private final int w;
	private final double capacity;
	private double flow;
	
	public FlowEdge(int v, int w, int capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
	
	public double capacity() {
		return capacity;
	}
	
	public double flow() {
		return flow;
	}
	
	public int other(int v) {
		if (this.v == v) return this.w;
		else if (this.w == v) return this.v;
		else throw new RuntimeException("Illegal vertice");
	}
	
	public double residualCapacityTo(int v) {
		if (this.v == v) return flow;
		else if (this.w == v) return capacity - flow;
		else throw new RuntimeException("Illegal vertice");
	}
	
	public void addResidualFlowTo(int v, double delta) {
		if (this.v == v) flow -= delta;
		else if (this.w == v) flow += delta;
		else throw new RuntimeException("Illegal vertice");
	}
}