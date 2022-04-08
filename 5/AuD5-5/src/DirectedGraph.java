import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class DirectedGraph {

	public static final double INFINITY = Double.MAX_VALUE;
	private static Map<String, Node> nodes = new HashMap<String, Node>();

	public static DirectedGraph readGraph(String file) throws FileNotFoundException {
		DirectedGraph obj = new DirectedGraph();
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
			// node1.neighbors.add(new Edge(node2, weight));

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

	public boolean BFS(String start, String dest, int max) {
		return true;
		
	}

	public void BFSrec(Node root, Node dest, int max){
		LinkedList<Node> queue = new LinkedList<Node>();

		for (int i = 0; i < root.neighbors.size(); i++) {
			queue.add(root.neighbors.get(i).dest);	
		}

		for (int i = 0; i < root.neighbors.size(); i++) {


			if (queue.get(i) == null) {

			}

			if (queue.get(i) == dest) {
				
			}

			else {
				BFSrec(queue.get(i), dest, max);
			}

		}

	}

	// public void printPath(String dest) {}
	
	public void print() {
		for(Map.Entry<String, Node> e : nodes.entrySet()){
			String s = e.getKey();
			Node d = e.getValue();
			System.out.println(s + "-> Nachbarn: " + d.neighbors.toString() + "\n");
		}
	}

	
	
	
}