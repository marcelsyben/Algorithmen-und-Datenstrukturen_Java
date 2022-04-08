
public class RedBlackTree {

	private RBTNode nil;
	private RBTNode root;

	public RedBlackTree() {
		nil = new RBTNode(-1, "nil");
		nil.color = RBTNode.black;
		nil.left = nil;
		nil.right = nil;
		root = nil;
	}

	public void insert(int k, String s) {

		RBTNode node = new RBTNode(k, s);
		node.parent = nil;
		node.left = nil;
		node.right = nil;
		node.color = RBTNode.red;

		RBTNode y = nil;
		RBTNode x = this.root;

		while (x != nil) {
			y = x;
			if (node.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		node.parent = y;
		if (y == nil) {
			root = node;
		} else if (node.key < y.key) {
			y.left = node;
		} else {
			y.right = node;
		}

		if (node.parent == nil) {
			node.color = RBTNode.black;
			return;
		}

		if (node.parent.parent == nil) {
			return;
		}

		fixInsert(node);
	}

	public String search(int k) {
		return searchTreeHelper(this.root, k).val;
	}

	public int height() {
		return heightRec(root);
	}

	public boolean CheckRB() {
		return validRec(root);
	}

	private void preOrderHelper(RBTNode node) {
		if (node != nil) {
			System.out.print(node.key + " ");
			preOrderHelper(node.left);
			preOrderHelper(node.right);
		}
	}

	private void inOrderHelper(RBTNode node) {
		if (node != nil) {
			inOrderHelper(node.left);
			System.out.print(node.key + " ");
			inOrderHelper(node.right);
		}
	}

	private void postOrderHelper(RBTNode node) {
		if (node != nil) {
			postOrderHelper(node.left);
			postOrderHelper(node.right);
			System.out.print(node.key + " ");
		}
	}

	private RBTNode searchTreeHelper(RBTNode node, int key) {
		if (node == nil || key == node.key) {
			return node;
		}

		if (key < node.key) {
			return searchTreeHelper(node.left, key);
		}
		return searchTreeHelper(node.right, key);
	}

	
	private void fixInsert(RBTNode k) {
		RBTNode u;
		while (k.parent.color == RBTNode.red) {
			if (k.parent == k.parent.parent.right) {
				u = k.parent.parent.left; 
				if (u.color == RBTNode.red) {
					
					u.color = RBTNode.black;
					k.parent.color = RBTNode.black;
					k.parent.parent.color = RBTNode.red;
					k = k.parent.parent;
				} else {
					if (k == k.parent.left) {
						
						k = k.parent;
						rightRotate(k);
					}
					
					k.parent.color = RBTNode.black;
					k.parent.parent.color = RBTNode.red;
					leftRotate(k.parent.parent);
				}
			} else {
				u = k.parent.parent.right;

				if (u.color == RBTNode.red) {
					
					u.color = RBTNode.black;
					k.parent.color = RBTNode.black;
					k.parent.parent.color = RBTNode.red;
					k = k.parent.parent;
				} else {
					if (k == k.parent.right) {
						
						k = k.parent;
						leftRotate(k);
					}
					
					k.parent.color = RBTNode.black;
					k.parent.parent.color = RBTNode.red;
					rightRotate(k.parent.parent);
				}
			}
			if (k == root) {
				break;
			}
		}
		root.color = RBTNode.black;
	}

	private void printHelper(RBTNode root, String indent, boolean last) {
		
		if (root != nil) {
			System.out.print(indent);
			if (last) {
				System.out.print("R----");
				indent += "     ";
			} else {
				System.out.print("L----");
				indent += "|    ";
			}

			String sColor = root.color == RBTNode.red ? "RED" : "BLACK";
			System.out.println(root.key + "(" + sColor + ")");
			printHelper(root.left, indent, false);
			printHelper(root.right, indent, true);
		}
	}

	// Pre-Order traversal
	// RBTNode.Left Subtree.Right Subtree
	public void preorder() {
		preOrderHelper(this.root);
	}

	// In-Order traversal
	// Left Subtree . RBTNode . Right Subtree
	public void inorder() {
		inOrderHelper(this.root);
	}

	// Post-Order traversal
	// Left Subtree . Right Subtree . RBTNode
	public void postorder() {
		postOrderHelper(this.root);
	}

	public void leftRotate(RBTNode x) {
		RBTNode y = x.right;
		x.right = y.left;
		if (y.left != nil) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	// rotate right at node x
	public void rightRotate(RBTNode x) {
		RBTNode y = x.left;
		x.left = y.right;
		if (y.right != nil) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			this.root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}

	
	public void prettyPrint() {
		printHelper(this.root, "", true);
	}

	private int heightRec(RBTNode root) { // https://stackoverflow.com/questions/2597637/finding-height-in-binary-search-tree
		if (root == nil) {
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

	private boolean validRec(RBTNode node) { 
		if(bh(root) > -1) {
			if(root.color != RBTNode.red) {
				if(preOrderdurchlauf(root)) {
					return true;
				}
			}
		}
		return false;
	}

	private int bh(RBTNode root) {
		if (root == nil) return 0;
		int lbh = bh(root.left);
		int rbh = bh(root.right);
		if (lbh != rbh || lbh == -1 || rbh == -1) return -1;
		if (root.color == RBTNode.black) return lbh + 1;
		else return lbh; 
	}
	
	private boolean preOrderdurchlauf(RBTNode node) {
		if (node != nil) {
			if(node.color == RBTNode.red &&(node.left.color == RBTNode.red || node.right.color == RBTNode.red)) {
				return false;
			}
			preOrderdurchlauf(node.left);
			preOrderdurchlauf(node.right);
		}
		return true;
	}
	
	public void change() {
		changeRec(root);
	}

	public RBTNode changeRec(RBTNode z) {
		if (z != nil) {
			if (z.color == RBTNode.red) {
				z.left.color = RBTNode.red;
			}
			else {
			changeRec(z.left);
			}
		}
		return z.left;
		
		
	}
	
	
}
