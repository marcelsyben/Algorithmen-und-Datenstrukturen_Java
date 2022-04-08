import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class DirectedGraph {
    public static final double INFINITY = Double.MAX_VALUE;

    private Map<String, Node> nodes = new HashMap<String, Node>(); 

    


    public void addNode(String s) 
    { 
        if (!(nodes.containsKey(s))) {
            nodes.put(s, new Node(s));
        }
    } 

    public void addEdge(String stadt1, String stadt2, double weight) {
        Node source = nodes.get(stadt1);
        Node dest = nodes.get(stadt2);
        source.neighbours.add(new Edge(dest, weight));
    }

    
    public DirectedGraph() throws FileNotFoundException {
        readGraph("OS_Map.txt");
    }



    public static DirectedGraph readGraph(String file) throws FileNotFoundException {
        File entries = new File (file);
        Scanner scan = new Scanner(entries);

        

        while (scan.hasNextLine()) {

            String stadt1 = scan.next();
            String stadt2 = scan.next();


            double weight = Double.parseDouble(scan.next());
            addNode(stadt1);
            addNode(stadt2);
            addEdge(stadt1, stadt2, weight);
            

        }



        scan.close();
        return null;
    }

    public boolean BFS (String start, String dest, int max) {
        return false;

    }

    public void printPath (String dest) {

    }
    
}
