public class Test1 {
    
    public static void main(String[] args)
    {
        BST tree = new BST();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50,"Test");
        tree.insert(30,"Test1");
        tree.insert(20,"Test2");
        tree.insert(40,"Test3");
        tree.insert(70,"Test4");
        tree.insert(60,"Test5");
        tree.insert(80,"Test6");
 
        System.out.println(
            "Inorder traversal of the given tree");
        tree.inorder();
 
        System.out.println("\nDelete 20");
        tree.remove(20);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 30");
        tree.remove(30);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 50");
        tree.remove(50);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
    }
}
