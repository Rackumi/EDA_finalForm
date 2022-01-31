package examenes.ordinaria_2021_2022.test;

import examenes.ordinaria_2021_2022.solution.QuickTree;
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
public class QuickTreeTest {
    
    public QuickTreeTest() {
    }

    /**
     * Test of search method, of class QuickBinaryTree.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        QuickTree<String> t = new QuickTree<>();
        Position<String> p = t.addRoot("+");
        t.add("2",p);
        Position<String> h = t.add("*",p);
        t.add("3",h);
        Position<String> n5 = t.add("5",h);
        
        Position<String> f = t.search("5");
        assertEquals(f, n5);
    }
    
    /**
     * Test of search method, of class QuickBinaryTree.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        QuickTree<String> t = new QuickTree<>();
        Position<String> p = t.addRoot("+");
        t.add("2",p);
        Position<String> h = t.add("*",p);
        t.add("3",h);
        Position<String> n5 = t.add("5",h);
        t.remove(n5);        
        
        Position<String> f = t.search("5");
        assertEquals(f, null);
    }

}