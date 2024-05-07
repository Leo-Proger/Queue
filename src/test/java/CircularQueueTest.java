import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CircularQueueTest {

    @Test
    public void testCreateCircularQueue() {
        CircularQueue queue = new CircularQueue(5);
        assertNotNull(queue);
        assertEquals(5, queue.size);
        assertArrayEquals(new int[6], queue.getQueue());
        assertEquals(0, queue.getPutLocation());
        assertEquals(0, queue.getGetLocation());
    }

    @Test
    public void testCreateCircularQueueWithNegativeSize() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CircularQueue(-1));
    }

    @Test
    public void testPutAndGet() {
        CircularQueue queue = new CircularQueue(5);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertArrayEquals(new int[]{1, 2, 3, 0, 0, 0}, queue.getQueue());
        assertEquals(3, queue.getPutLocation());
        assertEquals(0, queue.getGetLocation());

        assertEquals(1, queue.get());
        assertEquals(2, queue.get());
        assertEquals(3, queue.get());

        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0}, queue.getQueue());
        assertEquals(3, queue.getPutLocation());
        assertEquals(3, queue.getGetLocation());

        Assertions.assertThrows(NoSuchElementException.class, () -> queue.get());
    }

    @Test
    public void testReset() {
        CircularQueue queue = new CircularQueue(5);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertArrayEquals(new int[]{1, 2, 3, 0, 0, 0}, queue.getQueue());
        assertEquals(3, queue.getPutLocation());
        assertEquals(0, queue.getGetLocation());

        queue.reset();

        assertArrayEquals(new int[6], queue.getQueue());
        assertEquals(0, queue.getPutLocation());
        assertEquals(0, queue.getGetLocation());
    }

    @Test
    public void testCircularityAfterReset() {
        CircularQueue queue = new CircularQueue(3);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertEquals(1, queue.get());

        queue.reset();

        queue.put(4);
        assertEquals(4, queue.get());
    }

    @Test
    public void testQueueOverflowAfterReset() {
        CircularQueue queue = new CircularQueue(3);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.put(4));

        queue.reset();

        queue.put(1);
        queue.put(2);
        queue.put(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.put(4));
    }

    @Test
    public void testQueueUnderflowAfterReset() {
        CircularQueue queue = new CircularQueue(3);

        queue.put(1);
        assertEquals(1, queue.get());
        assertThrows(NoSuchElementException.class, queue::get);

        queue.reset();

        assertThrows(NoSuchElementException.class, queue::get);
    }
}