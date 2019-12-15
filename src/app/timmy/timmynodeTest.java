package app.timmy;

/**
 * timmynodeTest
 */
public class timmynodeTest {

    public static void main(String[] args) {
        BTree tree = new BTree();
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);


        do {
            tree.inorder();
            System.out.println("Removing largest");
        } while (tree.removeMaximum());

        
    }

}