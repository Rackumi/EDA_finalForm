package test.linear.stack.floatStack;

import org.junit.Test;
import structures.linear.stack.floatStack.FloatArrayStack;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for class FloatArrayStack
 *
 * @author Rackumi
 */
public class FloatArrayStackTest {

    @Test
    public void testIsEmpty() {
        FloatArrayStack stack = new FloatArrayStack(5);
        assertTrue(stack.isEmpty());
        stack.push(3F);
        assertFalse(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testPopException(){
        FloatArrayStack stack = new FloatArrayStack(5);
        stack.pop();
    }

    @Test
    public void testPop(){
        FloatArrayStack stack = new FloatArrayStack(5);
        stack.push(1F);
        stack.push(2F);
        Float salida = stack.pop();
        assertEquals(salida, 2F);
        salida = stack.pop();
        assertEquals(salida, 1F);
    }

    @Test
    public void testSize(){
        FloatArrayStack stack = new FloatArrayStack(5);
        assertEquals(stack.size(), 0);
        for(int i=0; i<10; i++){
            stack.push((float)i);
            assertEquals(stack.size(), i+1);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testTopException(){
        FloatArrayStack stack = new FloatArrayStack(5);
        stack.top();
    }

    @Test
    public void testTop(){
        FloatArrayStack stack = new FloatArrayStack(5);
        for(float i=0; i<3; i++){
            stack.push(i);
        }
        assertEquals(stack.top().intValue(), 2);
    }

    @Test
    public void testPush(){
        FloatArrayStack stack = new FloatArrayStack(5);
        for(float i=0; i<6; i++){
            stack.push(i);
        }
        assertEquals(stack.size(), 6);
    }

}
