package test.linear.stack.genericStack;

import junit.framework.TestCase;
import org.junit.Test;
import structures.linear.stack.genericStack.GenericArrayStack;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for class GenericArrayStack
 *
 * @author Rackumi
 */
public class GenericArrayStackTest {

    @Test
    public void testIsEmpty() {
        GenericArrayStack<Integer> stack = new GenericArrayStack<Integer>(5);
        TestCase.assertTrue(stack.isEmpty());
        stack.push(3);
        TestCase.assertFalse(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testPopException(){
        GenericArrayStack<Integer> stack = new GenericArrayStack<Integer>(5);
        stack.pop();
    }

    @Test
    public void testPop(){
        GenericArrayStack<Integer> stack = new GenericArrayStack<Integer>(5);
        stack.push(1);
        stack.push(2);
        int salida = stack.pop();
        assertEquals(salida, 2);
        salida = stack.pop();
        assertEquals(salida, 1);
    }

    @Test
    public void testSize(){
        GenericArrayStack<Integer> stack = new GenericArrayStack<Integer>(5);
        assertEquals(stack.size(), 0);
        for(int i=0; i<10; i++){
            stack.push(i);
            assertEquals(stack.size(), i+1);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testTopException(){
        GenericArrayStack<Integer> stack = new GenericArrayStack<Integer>(5);
        stack.top();
    }

    @Test
    public void testTop(){
        GenericArrayStack<Integer> stack = new GenericArrayStack<Integer>(5);
        for(int i=0; i<3; i++){
            stack.push(i);
        }
        assertEquals(stack.top().intValue(), 2);
    }

    @Test
    public void testPush(){
        GenericArrayStack<Integer> stack = new GenericArrayStack<Integer>(5);
        for(int i=0; i<6; i++){
            stack.push(i);
        }
        assertEquals(stack.size(), 6);
    }

    }
