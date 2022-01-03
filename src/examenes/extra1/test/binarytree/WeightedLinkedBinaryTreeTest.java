package examenes.extra1.test.binarytree;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import examenes.extra1.source.binarytree.WeightedLinkedBinaryTree;
import structures.Position;
import org.junit.Test;

/**
 *
 * @author Rackumi
 */
public class WeightedLinkedBinaryTreeTest {
    
    private WeightedLinkedBinaryTree<String> t;
    /**
     * Test of size method, of class WeightedLinkedBinaryTree.
     */
    @Test
    public void testSize() {
        t = new WeightedLinkedBinaryTree<>();
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2",3);
        Position<String> h = t.insertRight(p, "*",5);
        t.insertLeft(h, "3",1);
        t.insertRight(h, "5",0);
        assertEquals(t.size(), 5);
    }

    /**
     * Test of isEmpty method, of class WeightedLinkedBinaryTree.
     */
    @Test
    public void testIsEmpty() {
        t = new WeightedLinkedBinaryTree<>();
        assertTrue(t.isEmpty());
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2",1);
        Position<String> h = t.insertRight(p, "*",6);
        t.insertLeft(h, "3",4);
        t.insertRight(h, "5",4);
        assertFalse(t.isEmpty());
    }

    /**
     * Test of children method, of class WeightedLinkedBinaryTree.
     */
    @Test
    public void testGetWeight() {
        t = new WeightedLinkedBinaryTree<>();
        Position<String> p = t.addRoot("+");
        Position<String> h1 = t.insertLeft(p, "2",2);
        Position<String> h2 = t.insertRight(p, "*",1);

        assertEquals(2,t.getWeight(p,h1));
        assertEquals(1,t.getWeight(p,h2));
    }
    
    /**
     * Test of children method, of class WeightedLinkedBinaryTree.
     */
    @Test
    public void testGetWeightError() {
        t = new WeightedLinkedBinaryTree<>();
        Position<String> p = t.addRoot("+");
        Position<String> h1 = t.insertLeft(p, "2",2);
        Position<String> h2 = t.insertRight(p, "*",1);

        try {
            t.getWeight(h2,h1);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}