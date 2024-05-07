package IntegerQueue;

import java.util.NoSuchElementException;

public class FixedQueue implements IntegerQueue {
    public final int size;

    private int[] queue;
    private int putLocation = 0; // Индекс элемента очереди, по которому будет вставлен следующий элемент
    private int getLocation = 0; // Индекс элемента очереди, который будет возвращен при чтении
    private int count = 0; // Счетчик элементов очереди

    // Создается новая очередь с заданным размером и будет заполнена нулями
    public FixedQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Размер очереди не может быть отрицательным");
        }
        this.size = size;
        this.queue = new int[size];
    }

    // Создается копия другой очереди
    public FixedQueue(FixedQueue q) {
        this.size = q.size;
        this.queue = new int[size];
        this.getLocation = q.getLocation;
        this.putLocation = q.putLocation;

        System.arraycopy(q.queue, 0, queue, 0, q.putLocation);
    }

    // Вставка элемента в конец очереди
    public void put(int value) {
        if (count >= size) {
            throw new ArrayIndexOutOfBoundsException("Очередь переполнена");
        }
        queue[putLocation++] = value;
        if (putLocation == size) {
            putLocation = 0;
        }
        count++;
    }

    // Прочитать элемент очереди
    public int get() {
        if (count == 0) {
            throw new NoSuchElementException("В очереди больше нет элементов");
        }
        int result = queue[getLocation];
        queue[getLocation++] = 0;
        if (getLocation == size) {
            getLocation = 0;
        }
        count--;
        return result;
    }

    public void reset() {
        queue = new int[size];
        getLocation = putLocation = count = 0;
    }

    public int[] getQueue() {
        return queue;
    }

    public int getPutLocation() {
        return putLocation;
    }

    public int getGetLocation() {
        return getLocation;
    }

    public int getCount() {
        return count;
    }
}