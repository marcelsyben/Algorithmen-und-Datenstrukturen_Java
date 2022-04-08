public class RedBlackTree {
  private RBTNode root;
  private RBTNode nil = new RBTNode(-1, "nil");



  public int height() {
		return heightRec(root);
  }
  
  public boolean isValidRBT() {
    return validRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  // Preorder
  private void preOrderHelper(RBTNode node) {
    if (node != nil) {
      System.out.print(node.key + " ");
      preOrderHelper(node.left);
      preOrderHelper(node.right);
    }
  }

  // Inorder
  private void inOrderHelper(RBTNode node) {
    if (node != nil) {
      inOrderHelper(node.left);
      System.out.print(node.key + " ");
      inOrderHelper(node.right);
    }
  }

  // Post order
  private void postOrderHelper(RBTNode node) {
    if (node != nil) {
      postOrderHelper(node.left);
      postOrderHelper(node.right);
      System.out.print(node.key + " ");
    }
  }

  // Search the tree
  private RBTNode searchTreeHelper(RBTNode node, int key) {
    if (node == nil || key == node.key) {
      return node;
    }

    if (key < node.key) {
      return searchTreeHelper(node.left, key);
    }
    return searchTreeHelper(node.right, key);
  }

  // Balance the tree after deletion of a node
  private void fixDelete(RBTNode x) {
    RBTNode s;
    while (x != root && x.color == false) {
      if (x == x.parent.left) {
        s = x.parent.right;
        if (s.color == true) {
          s.color = false;
          x.parent.color = true;
          leftRotate(x.parent);
          s = x.parent.right;
        }

        if (s.left.color == false && s.right.color == false) {
          s.color = true;
          x = x.parent;
        } else {
          if (s.right.color == false) {
            s.left.color = false;
            s.color = true;
            rightRotate(s);
            s = x.parent.right;
          }

          s.color = x.parent.color;
          x.parent.color = false;
          s.right.color = false;
          leftRotate(x.parent);
          x = root;
        }
      } else {
        s = x.parent.left;
        if (s.color == true) {
          s.color = false;
          x.parent.color = true;
          rightRotate(x.parent);
          s = x.parent.left;
        }

        if (s.right.color == false && s.right.color == false) {
          s.color = true;
          x = x.parent;
        } else {
          if (s.left.color == false) {
            s.right.color = false;
            s.color = true;
            leftRotate(s);
            s = x.parent.left;
          }

          s.color = x.parent.color;
          x.parent.color = false;
          s.left.color = false;
          rightRotate(x.parent);
          x = root;
        }
      }
    }
    x.color = false;
  }

  private void rbTransplant(RBTNode u, RBTNode v) {
    if (u.parent == null) {
      root = v;
    } else if (u == u.parent.left) {
      u.parent.left = v;
    } else {
      u.parent.right = v;
    }
    v.parent = u.parent;
  }

  private void deleteNodeHelper(RBTNode node, int key) {
    RBTNode z = nil;
    RBTNode x, y;
    while (node != nil) {
      if (node.key == key) {
        z = node;
      }

      if (node.key <= key) {
        node = node.right;
      } else {
        node = node.left;
      }
    }

    if (z == nil) {
      System.out.println("Couldn't find key in the tree");
      return;
    }

    y = z;
    boolean yOriginalColor = y.color;
    if (z.left == nil) {
      x = z.right;
      rbTransplant(z, z.right);
    } else if (z.right == nil) {
      x = z.left;
      rbTransplant(z, z.left);
    } else {
      y = minimum(z.right);
      yOriginalColor = y.color;
      x = y.right;
      if (y.parent == z) {
        x.parent = y;
      } else {
        rbTransplant(y, y.right);
        y.right = z.right;
        y.right.parent = y;
      }

      rbTransplant(z, y);
      y.left = z.left;
      y.left.parent = y;
      y.color = z.color;
    }
    if (yOriginalColor == false) {
      fixDelete(x);
    }
  }

  // Balance the node after insertion
  private void fixInsert(RBTNode k) {
    RBTNode u;
    while (k.parent.color == true) {
      if (k.parent == k.parent.parent.right) {
        u = k.parent.parent.left;
        if (u.color == true) {
          u.color = false;
          k.parent.color = false;
          k.parent.parent.color = true;
          k = k.parent.parent;
        } else {
          if (k == k.parent.left) {
            k = k.parent;
            rightRotate(k);
          }
          k.parent.color = false;
          k.parent.parent.color = true;
          leftRotate(k.parent.parent);
        }
      } else {
        u = k.parent.parent.right;

        if (u.color == true) {
          u.color = false;
          k.parent.color = false;
          k.parent.parent.color = true;
          k = k.parent.parent;
        } else {
          if (k == k.parent.right) {
            k = k.parent;
            leftRotate(k);
          }
          k.parent.color = false;
          k.parent.parent.color = true;
          rightRotate(k.parent.parent);
        }
      }
      if (k == root) {
        break;
      }
    }
    root.color = false;
  }

  private void printHelper(RBTNode root, String indent, boolean last) {
    if (root != nil) {
      System.out.print(indent);
      if (last) {
        System.out.print("R----");
        indent += "   ";
      } else {
        System.out.print("L----");
        indent += "|  ";
      }

      String sColor = root.color == true ? "RED" : "BLACK";
      System.out.println(root.key + "(" + sColor + ")");
      printHelper(root.left, indent, false);
      printHelper(root.right, indent, true);
    }
  }

  public RedBlackTree() {
    this.root = nil;
  }

  public void preorder() {
    preOrderHelper(this.root);
  }

  public void inorder() {
    inOrderHelper(this.root);
  }

  public void postorder() {
    postOrderHelper(this.root);
  }

  public RBTNode search(int k) {
    return searchTreeHelper(this.root, k);
  }

  public RBTNode minimum(RBTNode node) {
    while (node.left != nil) {
      node = node.left;
    }
    return node;
  }

  public RBTNode maximum(RBTNode node) {
    while (node.right != nil) {
      node = node.right;
    }
    return node;
  }

  public RBTNode successor(RBTNode x) {
    if (x.right != nil) {
      return minimum(x.right);
    }

    RBTNode y = x.parent;
    while (y != nil && x == y.right) {
      x = y;
      y = y.parent;
    }
    return y;
  }

  public RBTNode predecessor(RBTNode x) {
    if (x.left != nil) {
      return maximum(x.left);
    }

    RBTNode y = x.parent;
    while (y != nil && x == y.left) {
      x = y;
      y = y.parent;
    }

    return y;
  }

  public void leftRotate(RBTNode x) {
    RBTNode y = x.right;
    x.right = y.left;
    if (y.left != nil) {
      y.left.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y;
    } else if (x == x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }
    y.left = x;
    x.parent = y;
  }

  public void rightRotate(RBTNode x) {
    RBTNode y = x.left;
    x.left = y.right;
    if (y.right != nil) {
      y.right.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y;
    } else if (x == x.parent.right) {
      x.parent.right = y;
    } else {
      x.parent.left = y;
    }
    y.right = x;
    x.parent = y;
  }

  public void insert(int k, String s) {
    RBTNode node = new RBTNode(k, s);
    node.parent = null;
    node.left = nil;
    node.right = nil;
    node.color = true;

    RBTNode y = null;
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
    if (y == null) {
      root = node;
    } else if (node.key < y.key) {
      y.left = node;
    } else {
      y.right = node;
    }

    if (node.parent == null) {
      node.color = false;
      return;
    }

    if (node.parent.parent == null) {
      return;
    }

    fixInsert(node);
  }

  public RBTNode getRoot() {
    return this.root;
  }

  public void deleteNode(int key) {
    deleteNodeHelper(this.root, key);
  }

  public void printTree() {
    printHelper(this.root, "", true);
  }

  public void changeRoot(int k) {
    root.key = k;
    root.color = true;
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

  private boolean validRec(RBTNode root, int min, int max) { // https://leetcode.com/problems/validate-binary-search-tree/solution/
		if (root == null) {
			return true;
		}
		if (root.key > min && root.key < max) {

      if (root.parent == null) {
        if ((root.left.color != root.color ||root.left == nil) 
          && (root.right.color != root.color || root.right == nil)) {

        } else {
          return false;
        }
        
      }

      return (validRec(root.left, min, root.key) && validRec(root.right, root.key, max));
    } 

    
    else {
			return false;
		}
	}
}



