import java.util.ArrayList;
import java.util.List;

public class Node {

	public String name;
	public List<Edge> neighbors;
	boolean visited;
	Node prev;
	double dist;

	public Node(String n) {
		this.name = n;
		this.visited = false;
		neighbors = new ArrayList<Edge>();
	}
	
	public void visited() {
		this.visited = true;
	}
	
	public void unvisited() {
		this.visited = false;
	}

}
