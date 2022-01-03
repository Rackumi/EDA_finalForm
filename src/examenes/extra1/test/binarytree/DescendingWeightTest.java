package examenes.extra1.test.binarytree;

import examenes.extra1.source.binarytree.DescendingWeight;
import examenes.extra1.source.binarytree.WeightedLinkedBinaryTree;
import structures.Position;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rackumi
 */
public class DescendingWeightTest {
    
    public DescendingWeightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculate method, of class DescendingWeight.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        WeightedLinkedBinaryTree<String> tree = new WeightedLinkedBinaryTree<>();
        Position<String> p = tree.addRoot("P");
        Position<String> h1 = tree.insertLeft(p, "H1", 2);
        Position<String> h2 = tree.insertLeft(h1, "H2", 3);
        Position<String> h3 = tree.insertLeft(h2, "H3", 5);
        Position<String> h4 = tree.insertRight(h2, "H4", 4);
        Position<String> h5 = tree.insertRight(p, "H5", 1);

        DescendingWeight<String> instance = new DescendingWeight<>();
        
        assertEquals(1,instance.calculate(tree, p));
        assertEquals(7,instance.calculate(tree, h1));
    }
    
}