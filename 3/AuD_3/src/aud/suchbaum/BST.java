package aud.suchbaum;

public class BST {

    private BSTNode root;

    public BST() {


    }

    public void insert(int k, String s) {

        root = insertRecursive(root, k, s);

    }

    private BSTNode insertRecursive(BSTNode current, int k, String s) {

        if (current == null) {
            return new BSTNode(k, s);
        }

        if (k < current.key) {
            current.left = insertRecursive(current.left, k, s);
        } else if (k > current.key) {
            current.right = insertRecursive(current.right, k, s);
        } else {
            return current;
        }
        return current;
    }


    public String search (int k) {
        return searchRecursive(root,k);
    }


    private String searchRecursive(BSTNode current, int k) {
        if (current == null) {

            return null;
        }
        if (k == current.key) {
            return current.val;
        }

        if (k < current.key) {
            return searchRecursive(current.left,k);
        } else {
            return searchRecursive(current.right,k);
        }
    }


    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(BSTNode current) {

        if (current == null) {
            return 0;
        }

        int leftHeight = heightRecursive(current.left);
        int rightHeight = heightRecursive(current.right);

        if (leftHeight < rightHeight) {
            return leftHeight+1;
        } else {
            return rightHeight + 1;
        }
    }

    public boolean isValidBST() {
        return isValidBST(root);
    }


    private boolean isValidBST(BSTNode current) {

        if (current != null) {

            BSTNode prev = null;

            if (isValidBST(current.left)) {
                return false;
            }

            if (prev != null && current.key <= current.key) {
                return false;
            }

            prev = current;
            return isValidBST(current.right);
        }
        return true;
    }

    public void remove(int k) {
        root = removeRecursive(root,k);
    }

    private BSTNode removeRecursive(BSTNode current, int k) {

        if (current == null) {
            return null;
        }

        if (k < root.key) {
            current.left = removeRecursive(current.left,k);
        }

        else if (k > root.key) {
            current.right = removeRecursive(current.right,k);
        }

        else {
            if (current.left == null) {
                return current.right;
            }

            else if (current.right == null) {
                return current.left;
            }

            current.key = minKey(current.right);
            current.right = removeRecursive(current.right, current.key);

        }

        return current;
    }

    private int minKey (BSTNode current) {

        int minkey = current.key;
        while (current.left != null) {
            minkey = current.left.key;
            current = current.left;
        }
        return minkey;
    }
}
