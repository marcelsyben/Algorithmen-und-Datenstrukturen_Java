package aud3;

public class test {
    
    BSTNode deleteNode(BSTNode root, int k) {

        if (root == null) {
            return root;
        }

        if (k < root.key)  {

            root.left = deleteNode(root.left, k);
            return root;
        }

        else if (root.key < k) {

            root.right = deleteNode(root.right, k);
            return root;
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
