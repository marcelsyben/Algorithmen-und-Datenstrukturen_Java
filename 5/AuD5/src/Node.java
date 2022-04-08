import java.util.List;

class Node {
    public String name;
    public List<Edge> neighbours;
    boolean visited;
    Node prev;
    double dist;

    public Node (String n) {
        this.name = n;
        

    }
}