package examenes.parcial_2021_2022.test;

import java.util.HashSet;
import java.util.Set;

import structures.Position;
import org.junit.Test;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.iterators.InternalIterator;

import static org.junit.Assert.*;

/**
 * @author Rackumi
 */
public class InternalNodeIteratorTest {
    
    public InternalNodeIteratorTest() {
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
     * Test of hasNext method, of class InternalNodeIterator.
     */
    @Test
    public void testHasNextAndNext() {
        System.out.println("hasNext and next");
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        InternalIterator<Integer> instance = new InternalIterator<>(t);
        assertFalse(instance.hasNext());
        t.addRoot(25);
        instance = new InternalIterator<>(t);
        assertFalse(instance.hasNext());
        t = inicializa();
        instance = new InternalIterator<>(t);
        assertTrue(instance.hasNext());
        Set<Position<Integer>> l = new HashSet<>();
        l.add(p5); l.add(p6); l.add(p7);
        int i = 0;
        while (instance.hasNext()){
            assertTrue(l.contains(instance.next()));
            i++;
        }
        assertEquals(i,3);
    }
    
}