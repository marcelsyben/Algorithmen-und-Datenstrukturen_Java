import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class DirectedGraph {
    public static final double INFINITY = Double.MAX_VALUE;
    private Map<String, Node> nodes = new HashMap<String, Node>();



    public static DirectedGraph readGraph(String file) throws FileNotFoundException {

        File entries = new File(file);
        Scanner scan = new Scanner(entries);
        DirectedGraph obj = new DirectedGraph();
        while (scan.hasNextLine()) {

            String name1 = scan.next();
            String name2 = scan.next();
            double weight = Double.parseDouble(scan.next());

            Node node1 = new Node(name1);
            Node node2 = new Node(name2);

            if (!obj.nodes.containsKey(name1)) {
                obj.nodes.put(name1,node1);
            }

            if (!obj.nodes.containsKey(name2)) {
                obj.nodes.put(name2,node2);
            }
            
            obj.nodes.get(name1).neighbors.add(new Edge(node2, weight));
            //node1.neighbors.add(new Edge(node2, weight));

        }

        scan.close();
        return obj;
    }

    public DirectedGraph(){

    }

    public DirectedGraph(String file) {
        try {
            
            this.nodes = readGraph(file).nodes;

        } catch (FileNotFoundException e) {
            System.out.println(".txt Datei nicht gefunden");
        }


    }

    public boolean BFS(String start, String dest, int max) {

        try {
            DirectedGraph obj = readGraph("OS_Map.txt");

            Node anfang = obj.nodes.get(start);
            Node ziel = obj.nodes.get(dest);

            Queue<Node> queue = new LinkedList<Node>();

            BFSrec(anfang, ziel, max, queue);




        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }

    //public void printPath(String dest) {}

}