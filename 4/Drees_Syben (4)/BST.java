
public class BST {

	private BSTNode root;

	public BST() {
		this.root = null;
	}

	public void insert(int k, String s) { // https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
		root = insertRec(root, k, s);
	}

	public String search(int k) {
		return searchRec(root, k);
	}

	public int height() {
		return heightRec(root);
	}

	public boolean isValidBST() {
		return validRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public void remove(int k) {
		root = removeRec(root, k);
	}

	private BSTNode insertRec(BSTNode root, int k, String s) { // //https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
		if (root == null) {
			root = new BSTNode(k, s);
			return root;
		}
		if (k < root.key) {
			root.left = insertRec(root.left, k, s);
		} else if (k > root.key) {
			root.right = insertRec(root.right, k, s);
		}
		return root;
	}

	public void inorder() // https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	{
		inorderRec(root);
	}

	private void inorderRec(BSTNode root) // https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}

	private String searchRec(BSTNode root, int k) { // https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
		while (root != null) {
			if (root.key == k) {
				return root.val;
			}
			if (root.key < k) {
				return searchRec(root.right, k);
			}
			return searchRec(root.left, k);
		}
		 return  "";

	}

	private BSTNode removeRec(BSTNode root, int key) { // https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
		if (root == null) {
			return root;
		}
		if (key < root.key) {
			root.left = removeRec(root.left, key);
		} else if (key > root.key) {
			root.right = removeRec(root.right, key);
		} else {

			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			root.key = minValue(root.right);

			root.right = removeRec(root.right, root.key);
		}

		return root;
	}

	private int minValue(BSTNode root) { // https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	private boolean validRec(BSTNode root, int min, int max) { // https://leetcode.com/problems/validate-binary-search-tree/solution/
		if (root == null) {
			return true;
		}
		if (root.key > min && root.key < max) {
			return (validRec(root.left, min, root.key) && validRec(root.right, root.key, max));
		} else {
			return false;
		}
	}

	private int heightRec(BSTNode root) { // https://stackoverflow.com/questions/2597637/finding-height-in-binary-search-tree
		if (root == null) {
			return -1;
		}

		int lefth = heightRec(root.left);
		int righth = heightRec(root.right);

		if (lefth > righth) {
			return lefth + 1;
		} else {
			return righth + 1;
		}
	}
	
	public void changeRoot(int k) {
		root.key = k;
	}
}
