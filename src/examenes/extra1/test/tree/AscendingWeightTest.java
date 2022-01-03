package examenes.extra1.test.tree;

import examenes.extra1.source.tree.AscendingWeight;
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
public class AscendingWeightTest {
    
    public AscendingWeightTest() {
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
     * Test of calculate method, of class AscendingWeight.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        WeightedLinkedTree<String> tree = new WeightedLinkedTree<>();
        Position<String> p = tree.addRoot("+");
        Position<String> h1 = tree.add("2", p, 2);
        Position<String> h2 = tree.add("3", h1, 3);
        Position<String> h3 = tree.add("5", h2, 5);
        Position<String> h4 = tree.add("1", p, 1);

        AscendingWeight<String> instance = new AscendingWeight<>();
        
        assertEquals(10,instance.calculate(tree, h3));
        assertEquals(5,instance.calculate(tree, h2));
        assertEquals(1,instance.calculate(tree, h4));        
    }
    
}