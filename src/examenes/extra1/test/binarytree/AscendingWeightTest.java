package examenes.extra1.test.binarytree;

import examenes.extra1.source.binarytree.AscendingWeight;
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
        WeightedLinkedBinaryTree<String> tree = new WeightedLinkedBinaryTree<>();
        Position<String> p = tree.addRoot("+");
        Position<String> h1 = tree.insertLeft(p, "2", 2);
        Position<String> h2 = tree.insertLeft(h1, "3", 3);
        Position<String> h3 = tree.insertLeft(h2, "5", 5);
        Position<String> h4 = tree.insertRight(p, "1", 1);

        AscendingWeight<String> instance = new AscendingWeight<>();
        
        assertEquals(10,instance.calculate(tree, h3));
        assertEquals(5,instance.calculate(tree, h2));
        assertEquals(1,instance.calculate(tree, h4));        

    }
    
}