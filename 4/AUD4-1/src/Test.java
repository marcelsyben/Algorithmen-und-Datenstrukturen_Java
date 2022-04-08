import java.util.Random;

public class Test {

	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		Random random = new Random();
		int tmp = random.nextInt(10000);
		String text = Integer.toString(tmp);

		for (int i = 0; i < 4;) {
			tmp = random.nextInt(10000);
			Integer.toString(tmp);
			if (!tree.search(tmp).equals(text)) {
				tree.insert(tmp, text);
				i++;
			}
        }
        
        System.out.println(tree.isValidRBT());

        tree.changeRoot(-1);
    }


}