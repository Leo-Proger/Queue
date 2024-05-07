import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class FixedQueueTest {

    @Test
    public void testCreateFixedQueue() {
        FixedQueue queue = new FixedQueue(5);
        assertNotNull(queue);
        assertEquals(5, queue.size);
        assertArrayEquals(new int[5], queue.getQueue());
        assertEquals(0, queue.getPutLocation());
        assertEquals(0, queue.getGetLocation());
    }

    @Test
    public void testCreateFixedQueueWithNegativeSize() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new FixedQueue(-1));
    }

    @Test
    public void testCreateFixedQueueWithZeroSize() {
        FixedQueue queue = new FixedQueue(0);

        assertNotNull(queue);
        assertEquals(0, queue.size);
        assertArrayEquals(new int[0], queue.getQueue());

        assertEquals(0, queue.getPutLocation());
        assertEquals(0, queue.getGetLocation());
    }

    @Test
    public void testPutAndGet() {
        FixedQueue queue = new FixedQueue(5);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, queue.getQueue());
        assertEquals(3, queue.getPutLocation());
        assertEquals(0, queue.getGetLocation());
        assertEquals(3, queue.getCount());

        assertEquals(1, queue.get());
        assertEquals(2, queue.get());
        assertEquals(3, queue.get());

        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, queue.getQueue());
        assertEquals(3, queue.getPutLocation());
        assertEquals(3, queue.getGetLocation());
        assertEquals(0, queue.getCount());


        queue.put(4);
        queue.put(5);

        assertEquals(4, queue.get());
        assertEquals(5, queue.get());

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.put(6));
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.get());

    }

    @Test
    public void testReset() {
        FixedQueue queue = new FixedQueue(5);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        queue.reset();

        assertArrayEquals(new int[5], queue.getQueue());
        assertEquals(0, queue.getPutLocation());
        assertEquals(0, queue.getGetLocation());
    }

    @Test
    public void testCopyConstructor() {
        FixedQueue originalQueue = new FixedQueue(5);

        originalQueue.put(1);
        originalQueue.put(2);
        originalQueue.put(3);

        FixedQueue copyQueue = new FixedQueue(originalQueue);

        assertNotSame(originalQueue, copyQueue);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, copyQueue.getQueue());
        assertEquals(3, copyQueue.getPutLocation());
        assertEquals(0, copyQueue.getGetLocation());
    }

    @Test
    public void testToCircularQueue() {
        FixedQueue fixedQueue = new FixedQueue(5);
        for (int i = 0; i < 5; i++) {
            fixedQueue.put(i);
        }

        CircularQueue circularQueue = fixedQueue.toCircularQueue(fixedQueue);

        for (int i = 0; i < 5; i++) {
            assertEquals(i, circularQueue.get());
        }
    }

    @Test
    public void testToDynamicQueue() {
        FixedQueue fixedQueue = new FixedQueue(5);
        for (int i = 0; i < 5; i++) {
            fixedQueue.put(i);
        }

        DynamicQueue dynamicQueue = fixedQueue.toDynamicQueue(fixedQueue);

        for (int i = 0; i < 5; i++) {
            assertEquals(i, dynamicQueue.get());
        }
    }
}
