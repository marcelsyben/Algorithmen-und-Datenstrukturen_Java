import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DirectedGraph {
	
	public static final double INFINITY = Double.MAX_VALUE;

	private Map<String, Node> nodes = new HashMap<String, Node>();

	public DirectedGraph(String file) {
		try {
			readGraph(file);
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		}
	}

	public DirectedGraph() {

	}

	
	public static DirectedGraph readGraph(String file) throws FileNotFoundException {
		
		File entries = new File(file);
		Scanner scan = new Scanner(entries);
		DirectedGraph obj = new DirectedGraph();
		while (scan.hasNextLine()) {

			Node stadt1 = new Node(scan.next());
			Node stadt2 = new Node(scan.next());
			

			double weight = Double.parseDouble(scan.next());
			


			addNode(stadt1.name, obj);
			addNode(stadt2.name, obj);
			addEdge(stadt1, stadt2, weight, obj);
		}

		scan.close();
		return obj;
	}

	public boolean BFS(String start, String dest, int max) {
		if(start == null || dest == null) {
			return false;
		}
		
		return true;
		
	}

	public void printPath(String dest) {

	}
	
	public static Node addNode(String s, DirectedGraph obj) throws FileNotFoundException {
		if(!obj.getNodes().containsKey(s)) {
			Node tmp = new Node(s);
			obj.getNodes().put(s, tmp);
			return tmp;
		}
		return null;
	}
	
	public Map<String, Node> getNodes() {
		return nodes;
	}

	public static void addEdge(Node source, Node destination, double weight, DirectedGraph obj) {	
		Edge tmp = new Edge(destination, weight);
		
		if(source.neighbors == null) {
			source.neighbors.add(tmp);
			return;
		}

		if(source.neighbors == null || !source.neighbors.contains(tmp)) {
			source.neighbors.add(tmp);
		}
	}
}
