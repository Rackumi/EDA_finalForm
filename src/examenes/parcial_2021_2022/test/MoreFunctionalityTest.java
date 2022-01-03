package examenes.parcial_2021_2022.test;

import structures.Position;
import org.junit.Test;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.binarytree.MoreFunctionality;

import static org.junit.Assert.*;

/**
 * @author Rackumi
 */
public class MoreFunctionalityTest {
    
    public MoreFunctionalityTest() {
    }

    private Position<Integer> p5;
    private Position<Integer> p6, p7, p9;
    
    private BinaryTree<Integer> inicializa(){
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        p5 = t.addRoot(5);
        p6 = t.insertLeft(p5, 6);
        p7 = t.insertRight(p5, 7);
        t.insertLeft(p6,8);
        p9 = t.insertRight(p6,9);
        t.insertLeft(p7,10);
        t.insertRight(p7,11);
        return t;
    }

    /**
     * Test of isPerfect method, of class MoreFunctionality.
     */
    @Test
    public void testIsPerfect() {
        System.out.println("isPerfect");
        MoreFunctionality<Integer> instance = new MoreFunctionality<>();
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        assertTrue(instance.isPerfect(t));
        t.addRoot(20);
        assertFalse(instance.isPerfect(t));
        t = inicializa();
        assertTrue(instance.isPerfect(t));
        t.insertLeft(p9, 25);
        assertFalse(instance.isPerfect(t));
    }

}