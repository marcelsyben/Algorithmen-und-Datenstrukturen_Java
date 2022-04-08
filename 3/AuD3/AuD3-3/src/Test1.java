import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
		BST tree = new BST();
		Random random = new Random();
		int tmp = random.nextInt(10000);
		String text = Integer.toString(tmp);

        tree.insert(6666, "gangshit");

		for (int i = 0; i < 10;) {
			tmp = random.nextInt(10000);
			Integer.toString(tmp);
			if (!tree.search(tmp).equals(text)) {
				tree.insert(tmp, text);
				i++;
			}
		}

        tree.remove(6666);

		System.out.println("\n Höhe des Baumes beträgt: " + tree.height());
		System.out.println("Vorher:");
		System.out.println(tree.isValidBST());
		
		tree.changeRoot(-1);
		System.out.println(" Nachher:");
		System.out.println(tree.isValidBST());

    }
}