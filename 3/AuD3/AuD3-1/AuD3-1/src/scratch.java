

public class scratch {
    
    BSTNode removeRec1(BSTNode root, int k) {

        if (root == null) {
            return root;
        }

        if (k < root.key) {
            root.left = removeRec1(root, k);
            return root;
        }
        else if (root.key < k) {
            root.right = removeRec1(root, k);
        }

        if (root.left == null) {
            BSTNode temp = root.right;
            return temp;
        }
        else if (root.right == null) {
            BSTNode temp = root.left;
            return temp;
        }

        else {
            BSTNode succParent = root;

            BSTNode succ = root.right;

            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            if (succParent != root) {
                succParent.left = succ.right;
            }
            else {
                succParent.right = succ.right;
            }

            root.key = succ.key;

            return root;
        }
    }

}
