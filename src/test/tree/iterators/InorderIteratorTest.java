package test.tree.iterators;

import org.junit.Test;
import structures.Position;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.iterators.InOrderIterator;

import static org.junit.Assert.*;

/**
 * Test class for InOrderIterator
 *
 * @author Rackumi
 */
public class InorderIteratorTest {
    
    public InorderIteratorTest() {
    }

    /**
     * Test of hasNext method, of class InorderBinaryTreeIterator.
     */
    @Test
    public void testIterator() {
        System.out.println("testIterator");
        LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>();
        Position<Integer> a = t.addRoot(4);
        Position<Integer> b = t.insertLeft(a,2);
        Position<Integer> c = t.insertRight(a,8);
        Position<Integer> d = t.insertLeft(b,1);
        Position<Integer> e = t.insertRight(b,3);
        Position<Integer> f = t.insertLeft(c,6);
        Position<Integer> g = t.insertRight(c,9);
        Position<Integer> h = t.insertLeft(f,5);
        Position<Integer> i = t.insertRight(f,7);
        

        String salida = "";
        InOrderIterator<Integer> it = new InOrderIterator<>(t);
        while (it.hasNext()) {
            salida += it.next().getElement().toString();
        }
        assertEquals("123456789",salida);
    }
 
}