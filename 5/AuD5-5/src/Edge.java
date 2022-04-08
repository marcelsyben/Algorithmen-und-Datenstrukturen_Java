class Edge {
    public Node dest;
    public double weight;
    
    public Edge(Node d, double w) {
        this.dest = d;
        this.weight = w;
    }

	@Override
	public String toString() {
		return dest.name;
	}
    
    
    }