import java.util.NoSuchElementException;

public class Queue {
    public final int size;

    private final int[] queue;
    private int getLocation = 0; // The index of the queue item that is returned when the item is read
    private int putLocation = 0; // The index by which the element will be inserted

    /**
     * This constructor creates a new, empty queue based on the size parameter
     *
     * @param size the size of the queue being created
     */
    public Queue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Queue size cannot be negative");
        }
        this.size = size;
        this.queue = new int[size];
    }

    /**
     * This constructor creates a copy of the queue
     *
     * @param q this is another queue that needs to be copied
     */
    public Queue(Queue q) {
        //
        this.size = q.size;
        this.queue = new int[size];

        for (int i = 0; i < q.size; i++) {
            queue[i] = q.get();
        }
    }

    /**
     * Inserts an item into the queue
     *
     * @param el the element (number) to be inserted
     */
    public void put(int el) {
        if (putLocation >= size) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        queue[putLocation++] = el;
    }

    /**
     * Reads the very first added element and returns it
     * @return the returned item is from the queue, it will not be possible to read it again
     */
    public int get() {
        if (getLocation >= size) {
            throw new NoSuchElementException("The queue has not more elements");
        }
        return queue[getLocation++];
    }
}
