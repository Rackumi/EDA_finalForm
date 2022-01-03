package practicas.practica3.test;

import practicas.practica3.ClosestInteger;
import structures.Position;
import structures.tree.binarySearchTree.BinarySearchTree;
import structures.tree.binarySearchTree.LinkedBinarySearchTree;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Rackumi
 */
public class ClosestIntegerTest {
    
    public ClosestIntegerTest() {
    }

    /**
     * Test of closest method, of class ClosestInteger.
     */
    @Test
    public void testClosest() {
        System.out.println("closest");
        ClosestInteger instance = new ClosestInteger();
        try{
            instance.closest(null, 0);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        
        BinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();
        tree.insert(24);
        tree.insert(15);
        tree.insert(12);
        Position<Integer> expResult = tree.insert(4);
        tree.insert(19);
        tree.insert(17);
        tree.insert(21);
        tree.insert(31);
        tree.insert(29);
        Position<Integer> dos = tree.insert(44);

        Position<Integer> result = instance.closest(tree, 5);
        assertEquals(expResult, result);
        assertEquals(dos, instance.closest(tree, 50));
    }
    
}