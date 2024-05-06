package FixedQueue.CharQueue;

import java.util.NoSuchElementException;

public class Queue implements CharQueue {
    public final int size;

    private final char[] queue;
    private int getLocation = 0; // Индекс элемента очереди, который будет возвращен при чтении
    private int putLocation = 0; // Индекс элемента очереди, по которому будет вставлен следующий элемент

    // Создается новая очередь с заданным размером и будет заполнена нулями
    public Queue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Размер очереди не может быть отрицательным");
        }
        this.size = size;
        this.queue = new char[size];
    }

    // Создается копия другой очереди
    public Queue(Queue q) {
        this.size = q.size;
        this.queue = new char[size];
        this.getLocation = q.getLocation;
        this.putLocation = q.putLocation;

        for (int i = 0; i < q.size; i++) {
            queue[i] = q.queue[i];
        }
    }

    // Вставка элемента в конец очереди
    public void put(char el) {
        if (putLocation >= size) {
            throw new ArrayIndexOutOfBoundsException("Очередь переполнена");
        }
        queue[putLocation++] = el;
    }

    // Прочитать элемент очереди
    public char get() {
        if (getLocation >= size) {
            throw new NoSuchElementException("В очереди больше нет элементов");
        }
        return queue[getLocation++];
    }
}
