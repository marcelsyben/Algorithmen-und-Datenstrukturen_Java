public class Test {
	public static void main(String[] args) {

		DirectedGraph dg = new DirectedGraph("OS_Map.txt");

		dg.BFS("Neuenkirchen", "Glandorf", 6);

		dg = new DirectedGraph("OS_Map.txt");

		dg.BFS("Neuenkirchen", "Glandorf", 5);

		dg.printPath("Bad_Essen");

	}

}
