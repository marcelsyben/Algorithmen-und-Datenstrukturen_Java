

public class Test2 {
    public static void main(String [] args){
    	RedBlackTree rbt = new RedBlackTree();
		


        for (int i=0;i<100;i++) {
            rbt.insert(i, "");

        }

        rbt.change();
        System.out.println(rbt.CheckRB());

    }
}
