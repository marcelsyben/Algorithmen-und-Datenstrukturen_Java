import java.util.Random;

public class Test {
    public static void main(String [] args){
    	RedBlackTree rbt = new RedBlackTree();
		


		Random random = new Random();
		int tmp = random.nextInt(10000);
		String text = Integer.toString(tmp);
		for (int i = 0; i < 10000;) {
			tmp = random.nextInt(10000);
			Integer.toString(tmp);
			if (!rbt.search(tmp).equals(text)) {
				rbt.insert(tmp, text);
				i++;
			}
		}
		
		System.out.println("Red-Black-Tree: \n");
//		rbt.prettyPrint();
		System.out.println(rbt.CheckRB());
		System.out.println("\nHöhe des Baumes: " + rbt.height() + "\n");
		
		System.out.println("Left-Child des ersten roten Knotens wird rot gefärbt: \n \nFalscher Red-Black-Tree: ");
		rbt.change();
//		rbt.prettyPrint();
		System.out.println(rbt.CheckRB());

    }
}
