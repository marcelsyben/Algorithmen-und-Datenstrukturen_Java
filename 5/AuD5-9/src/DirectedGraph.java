import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
			String[] s = scan.nextLine().split(" ");
			
			String name1 = s[0];
			String name2 = s[1];
			double weight = Double.parseDouble(s[2]);
		
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
		if (!nodes.containsKey(start) || !nodes.containsKey(dest)) {
			return false;
		}
		for (String key : nodes.keySet()) {
			nodes.get(key).dist = INFINITY;
			nodes.get(key).visited = false;
			nodes.get(key).prev = null;
		}
		Node s = nodes.get(start);
		s.dist = 0;
		s.prev = null;
		s.visited = true;
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(s);

		while (!q.isEmpty()) {
			Node u = nodes.get(q.remove().name);
			if (u.dist > max) {
				u.prev = null;
				return false;
			}
			if (nodes.get(dest).equals(u)) {
				return true;
			}
			for (Edge e : u.neighbors) {
				Node next = nodes.get(e.dest.name);
				if (!next.visited) {
					next.visited = true;
					next.dist = u.dist + 1;
					next.prev = u;
					q.add(next);
				}
			}

		}
		return false;
	}
//}
//		LinkedList<Node> q = new LinkedList<Node>();
//		nodes.get(start).visited = true;
//		q.add(nodes.get(start));
//
//		while (!q.isEmpty()) {
//
//			Node current = q.poll();
//			for (int i = 0; i < current.neighbors.size(); i++) {
//				if (current.neighbors.get(i).dest.visited != true) {
//					current.neighbors.get(i).dest.visited = true;
//					current.neighbors.get(i).dest.prev = current;
//					current.neighbors.get(i).dest.dist = current.neighbors.get(i).dest.prev.dist + 1;
//					q.add(current.neighbors.get(i).dest);
//				}
//			}
//		}
//		if(nodes.get(dest).dist > max) {
//			return false;
//		}
//		return true;

	public void printPath(String dest) {

		ArrayList<Node> tmp = new ArrayList<>();
		Node current = nodes.get(dest);
		
		tmp.add(current);
		while(current != null && current.prev != null) {
			tmp.add(current.prev);

			current = current.prev;
		}
		
		for (int i = tmp.size() -1; i>=0; i--) {
			System.out.println(tmp.get(i));
		}
//		Node p = nodes.get(dest);
//
//		String[] tmp = new String[17];
//		int count = 1;
//		tmp[16 - count] = p.name;
//		while (p.prev != null) {
//			count++;
//			tmp[nodes.size() - count] = p.prev.name;
//			p = p.prev;
//		}
//		System.out.print("Von ");
//		for (int i = 0; i < count; i++) {
//			System.out.print(" " + tmp[nodes.size() - count + i]);
//			if (i == count - 1) {
//				nodes.get(dest).dist = count - 1;
//				break;
//			}
//			System.out.print(" nach ");
//		}
//		System.out.println();
	}

//	public void print() {
//				for(Map.Entry<String, Node> e : nodes.entrySet()){
//				  String s = e.getKey();
//				  Node d = e.getValue();
//				  System.out.println(s + "-> Nachbarn: " + d.neighbors + "\n");
//				}
//	}

}