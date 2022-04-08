import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class DirectedGraph {

	public static final double INFINITY = Double.MAX_VALUE;
	private Map<String, Node> nodes = new HashMap<String, Node>();

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

			obj.nodes.get(name1).neighbors.add(new Edge(obj.nodes.get(name2), weight));
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

		LinkedList<Node> q = new LinkedList<Node>();
		nodes.get(start).visited = true;
		q.add(nodes.get(start));

		while (!q.isEmpty()) {

			Node current = q.poll();
			if (current.dist > max) {
				System.out.println("Distanz zu gro�!");
				return false;
			}
			for (int i = 0; i < current.neighbors.size(); i++) {
				if (current.neighbors.get(i).dest.visited != true) {
					current.neighbors.get(i).dest.visited = true;
					current.neighbors.get(i).dest.prev = current;
					current.neighbors.get(i).dest.dist = current.neighbors.get(i).dest.prev.dist + 1;
					System.out.println(current.neighbors.get(i).dest.name + " " + current.neighbors.get(i).dest.dist);
					q.add(current.neighbors.get(i).dest);
				}
			}
		}

		return true;

	}

	public void printPath(String dest) {
		
		Node p = nodes.get(dest);
		
		String[] tmp = new String[16];
		int count = 1;
		tmp[16 - count] = p.name;
		while (p.prev != null) {
			count++;
			tmp[nodes.size() - count] = p.prev.name;
			p = p.prev;
		}
		System.out.print("Von ");
		for (int i = 0; i < count; i++) {
			System.out.print(" " + tmp[nodes.size() - count + i]);
			if (i == count - 1) {
				nodes.get(dest).dist = count - 1;
				break;
			}
			System.out.print(" nach ");
		}
		System.out.println();
	}

//	public void print() {
//				for(Map.Entry<String, Node> e : nodes.entrySet()){
//				  String s = e.getKey();
//				  Node d = e.getValue();
//				  System.out.println(s + "-> Nachbarn: " + d.neighbors + "\n");
//				}
//	}

}