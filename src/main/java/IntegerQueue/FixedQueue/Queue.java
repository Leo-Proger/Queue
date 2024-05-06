package IntegerQueue.FixedQueue;

import IntegerQueue.IntegerQueue;

import java.util.NoSuchElementException;

public class Queue implements IntegerQueue {
    public final int size;

    private final int[] queue;
    private int getLocation = 0; // Индекс элемента очереди, который будет возвращен при чтении
    private int putLocation = 0; // Индекс элемента очереди, по которому будет вставлен следующий элемент

    // Создается новая очередь с заданным размером и будет заполнена нулями
    public Queue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Размер очереди не может быть отрицательным");
        }
        this.size = size;
        this.queue = new int[size];
    }

    // Создается копия другой очереди
    public Queue(Queue q) {
        this.size = q.size;
        this.queue = new int[size];
        this.getLocation = q.getLocation;
        this.putLocation = q.putLocation;

        System.arraycopy(q.queue, 0, queue, 0, q.size);
    }

    // Вставка элемента в конец очереди
    public void put(int value) {
        if (putLocation >= size) {
            throw new ArrayIndexOutOfBoundsException("Очередь переполнена");
        }
        queue[putLocation++] = value;
    }

    // Прочитать элемент очереди
    public int get() {
        if (getLocation >= size) {
            throw new NoSuchElementException("В очереди больше нет элементов");
        }
        return queue[getLocation++];
    }
}
