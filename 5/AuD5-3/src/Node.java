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
        
        neighbors = new ArrayList<Edge>();
    }
}