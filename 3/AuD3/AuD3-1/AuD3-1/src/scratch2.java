

public class scratch2 {
    
    public void remove2(int k) {
         = removeRec2(root, k);
    }


    BSTNode removeRec2(BSTNode root, int k) {

        if (root == null) {
            return root;
        }

        if (k < root.key) {
            root.left = removeRec2(root, k);
            return root;
        }
        else if (root.key < k) {
            root.right = removeRec2(root, k);
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

            
            root = root.right;

            while (root.right != null) {
                root.parent = root;
                root = root.left;
            }

            if (root.parent != root) {
                root.parent.left = root.right;
            }
            else {
                root.parent.right = root.right;
            }



            return root;
        }
    }

}
