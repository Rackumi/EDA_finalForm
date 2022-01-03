package test.linear.stack.floatStack;

import org.junit.Test;
import structures.linear.stack.floatStack.FloatLinkedStack;

import static org.junit.Assert.*;

/**
 * Test class for FloatLinkedStack
 *
 * @author Rackumi
 */
public class FloatLinkedStackTest{

    @Test
    public void testSize(){
        FloatLinkedStack stack = new FloatLinkedStack();
        assertEquals(stack.size(), 0);
        for (int i=0;i<10;i++) {
            stack.push((float)i);
            assertEquals(stack.size(), i+1);
        }
    }

    @Test
    public void testIsEmpty(){
        FloatLinkedStack stack = new FloatLinkedStack();
        assertTrue(stack.isEmpty());
        stack.push(1F);
        assertFalse(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testTopException(){
        FloatLinkedStack stack = new FloatLinkedStack();
        stack.top();
    }

    @Test
    public void testTop(){
        FloatLinkedStack stack = new FloatLinkedStack();
        stack.push(1F);
        assertEquals((float)stack.top(),1F, 0);
        stack.push(2F);
        assertEquals((float)stack.top(),2F, 0);
    }

    @Test
    public void testPush(){
        FloatLinkedStack stack = new FloatLinkedStack();
        for(int i=0; i<10; i++){
            stack.push((float)i);
            assertEquals((float)stack.top(), i, 0);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testPopException(){
        FloatLinkedStack stack = new FloatLinkedStack();
        stack.pop();
    }

    @Test
    public void testPop(){
        FloatLinkedStack stack = new FloatLinkedStack();
        stack.push(1F);
        stack.push(2F);
        assertEquals((float)stack.pop(), 2, 0);
        assertEquals((float)stack.pop(), 1, 0);
    }

}
