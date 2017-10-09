import static org.junit.Assert.*;
import java.util.Random;


public class BinarySearchTreeTest {
    @org.junit.Test
    public void treeInsert() throws Exception {
        BinarySearchTree t = new BinarySearchTree();
        Random dice = new Random();
        for ( int i = 0; i < 10; i++ ) {
            t.treeInsert(t, new Node(null, null, null, dice.nextInt()));
        }
        t.inorderTreeWalk(t.root);
    }

    @org.junit.Test
    public void treeDeletion() throws Exception {
    }

    @org.junit.Test
    public void treeMinimum() throws Exception {
    }

    @org.junit.Test
    public void treeMaximum() throws Exception {
    }

    @org.junit.Test
    public void treeSuccessor() throws Exception {
    }

    @org.junit.Test
    public void treePredecessor() throws Exception {
    }

    @org.junit.Test
    public void inorderTreeWalk() throws Exception {
    }

    @org.junit.Test
    public void preorderTreeWalk() throws Exception {
    }

    @org.junit.Test
    public void postorderTreeWalk() throws Exception {
    }

    @org.junit.Test
    public void treeSearch() throws Exception {
    }

    @org.junit.Test
    public void iterativeTreeSearch() throws Exception {
    }

}