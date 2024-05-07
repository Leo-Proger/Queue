package CharQueue.DynamicQueue;

import CharQueue.CharQueue;

import java.util.NoSuchElementException;

public class Queue implements CharQueue {
    public final int size;

    private char[] queue;
    private int putLocation, getLocation;

    public Queue(int size) {
        this.size = size;
        queue = new char[size];
        putLocation = getLocation = 0;
    }

    public void put(char ch) {
        // Если в очереди больше нет места, то создаем новую очередь, в 2 раза большую, и копируем туда элементы
        if (putLocation == queue.length) {
            char[] tmp = new char[queue.length * 2];

            System.arraycopy(queue, 0, tmp, 0, queue.length);
            queue = tmp;
        }
        queue[putLocation++] = ch;
    }

    public char get() {
        if (getLocation == putLocation) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return queue[getLocation++];
    }

    public void reset() {
        queue = new char[size];
    }
}
