package test.linear.queue.floatQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import structures.linear.queue.floatQueue.FloatArrayQueue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for class FloatArrayQueue
 *
 * @author Rackumi
 */
public class FloatArrayQueueTest {

    FloatArrayQueue queue = new FloatArrayQueue(5);
    final int MAX=25;

    @org.junit.jupiter.api.BeforeEach
    void setUp(){

        for (int i = 0; i < MAX; i++) {
            queue.enqueue((float) i);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown(){
        queue = null;
    }

    @org.junit.jupiter.api.Test
    void testSize(){
        Assertions.assertEquals(queue.size(), MAX);
    }

    @org.junit.jupiter.api.Test
    void testIsEmpty(){
        assertFalse(queue.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testFront(){
        Assertions.assertEquals((float) queue.front(), 0);
    }

    @org.junit.jupiter.api.Test
    void testEnqueue(){
        int size = queue.size();
        for(int i=1; i<=10; i++){
            queue.enqueue((float) i);
            size++;
            Assertions.assertEquals(size, queue.size());
        }
    }

    @org.junit.jupiter.api.Test
    void testDequeue(){
        int actual = 0;
        while(!queue.isEmpty()){
            float element = queue.dequeue();
            Assertions.assertEquals(element,actual);
            actual++;
        }
        assertTrue(queue.isEmpty());
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> queue.dequeue());
        Assertions.assertEquals("The queue is empty", runtimeException.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testResize(){
        //assumeTrue reports if the condition is not met and the test is stopped, a stacktrace is reported,
        //and the test marked as ignored.
        Assumptions.assumeTrue(queue instanceof FloatArrayQueue, "Not an instance of FloatArrayQueue");

        //assumingThat if a test tha only executes in certain conditions
        //if the condition is not met the test will pass.
        Assumptions.assumingThat(true,
                ()->{
                    int start = 100;
                    int maxElements = 500;

                    //Empty Queue
                    while(!queue.isEmpty()) {
                        queue.dequeue();
                    }

                    //fill and exceed default capacity
                    for (int i = 0; i <maxElements ; i++) {
                        queue.enqueue((float) (i+start));
                    }

                    //retrieve all new elements
                    int actual = start;
                    while (!queue.isEmpty()) {
                        float element = queue.dequeue();
                        Assertions.assertEquals(element, actual);
                        actual++;
                    }
                    RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> queue.dequeue());
                    Assertions.assertEquals("The queue is empty", runtimeException.getMessage());
                });
    }

}