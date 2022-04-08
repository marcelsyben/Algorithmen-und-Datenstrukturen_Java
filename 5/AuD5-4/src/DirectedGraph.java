import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

class DirectedGraph {
    public static final double INFINITY = Double.MAX_VALUE;
    private Map<String, Node> nodes = new HashMap<String, Node>();

    DirectedGraph obj = new DirectedGraph();

    public DirectedGraph readGraph(String file) throws FileNotFoundException {

        File entries = new File(file);
        Scanner scan = new Scanner(entries);

        while (scan.hasNextLine()) {

            String name1 = scan.next();
            String name2 = scan.next();
            double weight = Double.parseDouble(scan.next());

            Node node1 = new Node(name1);
            Node node2 = new Node(name2);

            if (!obj.nodes.containsKey(name1)) {
                obj.nodes.put(name1, node1);
            }

            if (!obj.nodes.containsKey(name2)) {
                obj.nodes.put(name2, node2);
            }

            obj.nodes.get(name1).neighbors.add(new Edge(node2, weight));

        }

        scan.close();
        return obj;
    }

    public DirectedGraph() {

    }

    public DirectedGraph(String file) {
        try {

            this.nodes = readGraph(file).nodes;

        } catch (FileNotFoundException e) {
            System.out.println(".txt Datei nicht gefunden");
        }

    }

    public boolean BFS(String start, String dest, int max) throws FileNotFoundException {

        Node s = obj.nodes.get(start);
        Node d = obj.nodes.get(dest);

        LinkedList<Node> queue = new LinkedList<Node>();

        for (int i=0; i<s.neighbors.size(); i++){
            queue.add(s.neighbors.get(i).dest);
        }
        

        for (int i=0; i<queue.size();i++){
            if (s.neighbors.get(i) == null) {}

            if (s.neighbors.get(i).dest == s) {}

            else {
                BFSrec(s.neighbors.get(i).dest, dest, max);
            }

        }
    }

    public void BFSrec(Node start, String dest, int max){

    }







    //public void printPath(String dest) {}

}