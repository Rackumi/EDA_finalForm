package test.linear.stack.genericStack;

import org.junit.Test;
import structures.linear.stack.genericStack.GenericLinkedStack;

import static org.junit.Assert.*;

/**
 * Test class for GenericLinkedStack
 *
 * @author Rackumi
 */
public class GenericLinkedStackTest {

    @Test
    public void testSize(){
        GenericLinkedStack<Integer> stack = new GenericLinkedStack<Integer>();
        assertEquals(stack.size(), 0);
        for (int i=0;i<10;i++) {
            stack.push(i);
            assertEquals(stack.size(), i+1);
        }
    }

    @Test
    public void testIsEmpty(){
        GenericLinkedStack<Integer> stack = new GenericLinkedStack<Integer>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testTopException(){
        GenericLinkedStack<Integer> stack = new GenericLinkedStack<Integer>();
        stack.top();
    }

    @Test
    public void testTop(){
        GenericLinkedStack<Integer> stack = new GenericLinkedStack<Integer>();
        stack.push(1);
        assertEquals((int)stack.top(),1);
        stack.push(2);
        assertEquals((int)stack.top(),2);
    }

    @Test
    public void testPush(){
        GenericLinkedStack<Integer> stack = new GenericLinkedStack<Integer>();
        for(int i=0; i<10; i++){
            stack.push(i);
            assertEquals((int)stack.top(), i);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testPopException(){
        GenericLinkedStack<Integer> stack = new GenericLinkedStack<Integer>();
        stack.pop();
    }

    @Test
    public void testPop(){
        GenericLinkedStack<Integer> stack = new GenericLinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        assertEquals((int)stack.pop(), 2);
        assertEquals((int)stack.top(), 1);
    }

}