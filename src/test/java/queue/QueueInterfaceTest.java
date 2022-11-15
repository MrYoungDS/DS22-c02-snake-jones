package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueInterfaceTest {

    private QueueInterface<String> queue;

    @BeforeEach
    public void setup() {
        queue = new LinkedQueue<>();
    }

    @Test
    public void testEnqueueSize() {
        queue.enqueue("One");
        assertEquals(1, queue.size());
        queue.enqueue("Two");
        assertEquals(2, queue.size());
        queue.enqueue("Three");
        assertEquals(3, queue.size());
        queue.enqueue("Four");
        assertEquals(4, queue.size());
    }

    @Test
    public void testEnqueueSize2() {
        QueueInterface<Integer> queue = new LinkedQueue<>();
        int max = 100000;
        for(int i = 0; i < max; i ++){
            assertEquals(i, queue.size());
            queue.enqueue(i);
        }
    }

    @Test
    public void testEnqueueDequeueSize(){
        queue.enqueue("One");
        assertEquals(1, queue.size());
        queue.enqueue("Two");
        assertEquals(2, queue.size());
        queue.enqueue("Three");
        assertEquals(3, queue.size());
        queue.enqueue("Four");
        assertEquals(4, queue.size());
        assertEquals("One", queue.dequeue());
        assertEquals(3, queue.size());
        assertEquals("Two", queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals("Three", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("Four", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueDequeueSize2(){
        QueueInterface<Integer> queue = new LinkedQueue<>();
        //int max = 10;
        int max = 100000;
        for(int i = 0; i < max; i++){
            assertEquals(i, queue.size());
            queue.enqueue(i);
        }

        for(int i = max - 1; i >= 0; i--){
            assertEquals(i + 1, queue.size());
            Integer r = queue.dequeue();
            assertEquals((max-1) - i, r.intValue());
        }
    }

    @Test
    public void testEnqueueIsEmptyDequeue(){
        assertTrue(queue.isEmpty());

        assertEquals(queue, queue.enqueue("hello"));
        assertFalse(queue.isEmpty());

        assertEquals("hello", queue.dequeue());
        assertTrue(queue.isEmpty());

        assertEquals(queue, queue.enqueue("hello"));
        assertFalse(queue.isEmpty());

        assertEquals(queue, queue.enqueue("there"));
        assertFalse(queue.isEmpty());

        assertEquals(queue, queue.enqueue("world"));
        assertFalse(queue.isEmpty());

        assertEquals("hello", queue.dequeue());
        assertFalse(queue.isEmpty());

        assertEquals("there", queue.dequeue());
        assertFalse(queue.isEmpty());

        assertEquals("world", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueToString(){
        assertEquals("[]", queue.toString());

        queue.enqueue("Hello");
        assertEquals("[Hello]", queue.toString());

        QueueInterface<Integer> queue2 = new LinkedQueue<>();
        queue2.enqueue(1).enqueue(2).enqueue(3);
        assertEquals("[1, 2, 3]", queue2.toString());

        queue.enqueue("World");
        assertEquals("[Hello, World]", queue.toString());
    }

    @Test
    public void testQueueIteration(){
        QueueInterface<Integer> queue = new LinkedQueue<>();
        String expected = ""; // should use StringBuilder
        String result = "";
        //int max = 10;
        int max = 10000;
        for(int i = 0; i < max; i++){
            queue.enqueue(i);
            expected += i;
        }
        for(Integer n : queue)
        {
            result += n;
        }
        assertEquals(expected, result);
    }

    @Test
    public void testNullPointerException(){
        assertThrows(NullPointerException.class,
                () -> queue.enqueue(null),
                "Trying to enqueue a null value should throw null pointer.");
    }

    @Test
    public void testIllegalStateException1(){
        assertThrows(IllegalStateException.class,
                () -> queue.peek(),
                "Trying to peek at an empty list should throw illegal state.");

        assertThrows(IllegalStateException.class,
                () -> queue.dequeue(),
                "Trying to dequeue an empty list should throw illegal state.");
    }

    @Test
    public void testIllegalStateException2(){
        queue.enqueue("One").enqueue("Two").enqueue("Three");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertThrows(IllegalStateException.class,
                () -> queue.dequeue(),
                "Trying to dequeue more than you enqueue should throw illegal state.");
    }
}
