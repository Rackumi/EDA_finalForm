package examenes.extra3.test;

import examenes.extra3.source.ArithmeticEvaluator;
import structures.tree.binarytree.BinaryTree;
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
public class ArithmeticEvaluatorTest {
    
    public ArithmeticEvaluatorTest() {
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
     * Test of getTree method, of class ArithmeticEvaluator.
     */
    @Test
    public void testGetTree() {
        System.out.println("getTree");
        ArithmeticEvaluator instance = new ArithmeticEvaluator("1+12/2");
        BinaryTree<String> result = instance.getTree();
        assertEquals("+", result.root().getElement());
        assertEquals("1", result.left(result.root()).getElement());
        assertEquals("/", result.right(result.root()).getElement());
        assertEquals("2", result.right(result.right(result.root())).getElement());
        assertEquals("12", result.left(result.right(result.root())).getElement());
    }

    /**
     * Test of evaualte method, of class ArithmeticEvaluator.
     */
    @Test
    public void testEvaualte() {
        System.out.println("evaualte");
        ArithmeticEvaluator instance = new ArithmeticEvaluator("1+12/2");
        int expResult = 7;
        int result = instance.evaluate();
        assertEquals(expResult, result);
    }
    
}