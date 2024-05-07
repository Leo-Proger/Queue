package IntegerQueue.DynamicQueue;

import IntegerQueue.IntegerQueue;

import java.util.NoSuchElementException;

public class Queue implements IntegerQueue {
    public final int size;

    private int[] queue;
    private int putLocation, getLocation;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
        putLocation = getLocation = 0;
    }

    public void put(int value) {
        // Если в очереди больше нет места, то создаем новую очередь, в 2 раза большую, и копируем туда элементы
        if (putLocation == queue.length) {
            int[] tmp = new int[queue.length * 2];

            System.arraycopy(queue, 0, tmp, 0, queue.length);
            queue = tmp;
        }
        queue[putLocation++] = value;
    }

    public int get() {
        if (getLocation == putLocation) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return queue[getLocation++];
    }

    public void reset() {
        queue = new int[size];
    }
}
