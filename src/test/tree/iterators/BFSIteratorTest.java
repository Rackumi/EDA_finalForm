package test.tree.iterators;

import org.junit.Test;
import structures.Position;
import structures.tree.iterators.BFSIterator;
import structures.tree.narytree.LinkedTree;

import static org.junit.Assert.*;

/**
 * Test class for BFTIterator
 *
 * @author Rackumi
 */
public class BFSIteratorTest {
    
    public BFSIteratorTest() {
    }

    /**
     * Test of hasNext method, of class BreadthFirstTreeIterator.
     */
    @Test
    public void testIterator() {
        System.out.println("testIterator");
        LinkedTree<String> t = new LinkedTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", a);
        Position<String> e = t.add("E", c);
        Position<String> f = t.add("F", c);
        Position<String> g = t.add("G", c);
        Position<String> h = t.add("H", d);
        Position<String> i = t.add("I", f);
        Position<String> j = t.add("J", f);

        String salida = "";
        BFSIterator<String> it = new BFSIterator<>(t);
        while (it.hasNext()) {
            salida += it.next().getElement();
        }

        assertEquals("ABCDEFGHIJ",salida);
    }

}