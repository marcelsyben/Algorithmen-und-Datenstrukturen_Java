import java.util.ArrayList;
import java.util.List;


class Node {
    public String name;
    public List<Edge> neighbors;
    boolean visited;
    Node prev;
    double dist;
    
    public Node(String n) {
       this.name = n;
       this.neighbors = new ArrayList<Edge>();
       this.visited = false;
       this.dist = 0.0;
       this.prev = null;
    }

	@Override
	public String toString() {
		return  name ;
	}
	
	

	
    
    
}