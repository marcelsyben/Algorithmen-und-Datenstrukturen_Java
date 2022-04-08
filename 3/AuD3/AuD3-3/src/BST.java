
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
			BSTNode lchild = insertRec(root.left, k, s);
			root.left = lchild;

			lchild.parent = root;

		} else if (k > root.key) {
			BSTNode rchild = insertRec(root.right, k, s);
			root.right = rchild;

			rchild.parent = root;
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

			if (root == null) {
				return "";
			}

			if (root.key == k) {
				return root.val;
			}
			if (root.key < k) {
				return searchRec(root.right, k);
			}
			return searchRec(root.left, k);
		


	}

    private BSTNode removeRec(BSTNode root, int k) {

        if (root == null) {
            return null;
        }

        if (k < root.key) {
            root.left = removeRec(root.left, k);
		}
		
        else if (root.key < k) {
            root.right = removeRec(root.right, k);
        }

		else {
			if (root.left == null && root.right == null) {
				root = null;
			}

			else if (root.left == null) {
				
				root.right.parent = root.parent;
				root = root.right;
			}

			else if (root.right == null) {

				root.left.parent = root.parent;
				root = root.left;
			}

			else {
				BSTNode succ = findSuccessorRec(root.right);
				root.key = succ.key;
				root.val = succ.val;
				root.right = removeRec(root.right, succ.key);
			}
		}

	return root;
	}
	
	private BSTNode findSuccessorRec (BSTNode root) {
		if (root.left == null) {
			return root;
		}
		else {
			return findSuccessorRec(root.left);
		}
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


	public void print(BSTNode root) {
		
	}
}
