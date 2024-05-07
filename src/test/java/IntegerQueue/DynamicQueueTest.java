package IntegerQueue;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicQueueTest {
    @Test
    public void testQueueExpansion() {
        DynamicQueue queue = new DynamicQueue(2);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertEquals(1, queue.get());
        assertEquals(2, queue.get());
        assertEquals(3, queue.get());
    }

    @Test
    public void testQueueCopy() {
        DynamicQueue queue1 = new DynamicQueue(2);

        queue1.put(1);
        queue1.put(2);

        DynamicQueue queue2 = new DynamicQueue(queue1);

        assertEquals(1, queue2.get());
        assertEquals(2, queue2.get());
    }

    @Test
    public void testQueueUnderflow() {
        DynamicQueue queue = new DynamicQueue(2);
        assertThrows(NoSuchElementException.class, queue::get);
    }

    @Test
    public void testReset() {
        DynamicQueue queue = new DynamicQueue(2);

        queue.put(1);
        queue.put(2);

        queue.reset();

        assertThrows(NoSuchElementException.class, queue::get);
    }

    @Test
    public void testResetAndPut() {
        DynamicQueue queue = new DynamicQueue(2);

        queue.put(1);
        queue.put(2);

        queue.reset();

        queue.put(3);
        assertEquals(3, queue.get());
    }
}
