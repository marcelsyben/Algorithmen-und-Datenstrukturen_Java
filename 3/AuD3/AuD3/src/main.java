import java.util.Random;

public class main {

	public static void main(String[] args) {
		BST tree = new BST();
		Random random = new Random();
		int tmp = random.nextInt(10000);
		String text = Integer.toString(tmp);

		for (int i = 0; i < 10000;) {
			tmp = random.nextInt(10000);
			Integer.toString(tmp);
			if (!tree.search(tmp).equals(text)) {
				tree.insert(tmp, text);
				i++;
			}
		}

		for (int i = 0; i < 10000; i++) {
			if (i % 2 != 0) {
				tree.remove(i);
			}
		}

		System.out.println("\n Höhe des Baumes beträgt: " + tree.height());
		System.out.println("Vorher:");
		System.out.println(tree.isValidBST());
		
		tree.changeRoot(-1);
		System.out.println(" Nachher:");
		System.out.println(tree.isValidBST());

	}
}
