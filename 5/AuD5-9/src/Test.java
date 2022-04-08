public class Test {
	public static void main(String[] args) {

		DirectedGraph dg = new DirectedGraph("OS_Map.txt");

		System.out.println(dg.BFS("Neuenkirchen", "Osnabrueck", 6));
		dg.printPath("Osnabrueck");

		dg = new DirectedGraph("OS_Map.txt");

		System.out.println(dg.BFS("Neuenkirchen", "Osnabrueck", 10));
		
		dg.printPath("Osnabrueck");
		
		

	}

}
