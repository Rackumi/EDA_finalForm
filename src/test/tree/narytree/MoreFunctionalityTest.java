package test.tree.narytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import structures.Position;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTreeUtils;
import structures.tree.narytree.NAryTree;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rackumi
 */
public class MoreFunctionalityTest {
    
    public MoreFunctionalityTest() {
    }
    
    private NAryTree<Character> general(){
        NAryTree<Character> tree = new LinkedTree<>();
        
        Position<Character> r = tree.addRoot('A');
        tree.add('B', r);
        tree.add('C', r);
        Position<Character> hD = tree.add('D', r);
        Position<Character> hE = tree.add('E', r);
        tree.add('F', hD);
        Position<Character> hG = tree.add('G', hE);
        Position<Character> hH = tree.add('H', hE);
        tree.add('I', hE);
        Position<Character> hJ = tree.add('J', hG);
        tree.add('K', hH);
        tree.add('L', hJ);
        
        return tree;
        
    }

    /**
     * Test of leftView method, of class MoreFunctionality.
     */
    @Test
    public void testLeftView() {
        System.out.println("leftView");
        NAryTreeUtils<Character> instance = new NAryTreeUtils<Character>();
        try{
            instance.leftView(null);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        List<Character> l = new LinkedList<>();
        NAryTree<Character> t = new LinkedTree<>();
        assertEquals(instance.leftView(t).toString(), l.toString());
        l = Arrays.asList('A','B','F','J','L');
        t = general();
        assertEquals(instance.leftView(t).toString(),l.toString());
    }

    /**
     * Test of rightView method, of class MoreFunctionality.
     */
    @Test
    public void testRightView() {
        System.out.println("rightView");
        NAryTreeUtils<Character> instance = new NAryTreeUtils<>();
        try{
            instance.rightView(null);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        List<Character> l = new LinkedList<>();
        NAryTree<Character> t = new LinkedTree<>();
        assertEquals(instance.rightView(t).toString(), l.toString());
        l = Arrays.asList('A','E','I','K','L');
        t = general();
        assertEquals(instance.rightView(t).toString(),l.toString());
    }
    
}
