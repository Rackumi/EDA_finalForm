package examenes.extra1.test.tree;

import examenes.extra1.source.tree.DescendingWeight;
import examenes.extra1.source.tree.WeightedLinkedTree;
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
        WeightedLinkedTree<String> tree = new WeightedLinkedTree<>();
        Position<String> p = tree.addRoot("P");
        Position<String> h1 = tree.add("H1", p, 2);
        Position<String> h2 = tree.add("H2", h1, 3);
        Position<String> h3 = tree.add("H3", h2, 5);
        Position<String> h4 = tree.add("H4", h2, 4);
        Position<String> h5 = tree.add("H5", p, 1);

        DescendingWeight<String> instance = new DescendingWeight<>();
        
        assertEquals(1,instance.calculate(tree, p));
        assertEquals(7,instance.calculate(tree, h1));
    }

}