package CharQueue.CircularQueue;

import CharQueue.CharQueue;

import java.util.NoSuchElementException;

public class Queue implements CharQueue {
    private final char[] queue;
    private int putLocation, getLocation;

    // Создает очередь с заданным размером
    public Queue(int size) {
        queue = new char[size + 1];
        putLocation = getLocation = 0;
    }

    // Добавить символ в очередь
    public void put(char ch) {
        /* Очередь переполнена, если putLocation на единицу меньше getLocation или
        putLocation указывает на конец массива, а getLocation - на его начало */
        if (putLocation + 1 == getLocation || ((putLocation == queue.length - 1) && (getLocation == 0))) {
            throw new ArrayIndexOutOfBoundsException("Очередь переполнена");
        }
        queue[putLocation++] = ch;
        if (putLocation == queue.length) putLocation = 0; // Закольцевать
    }

    // Прочитать символ очереди
    public char get() {
        if (getLocation == putLocation) {
            throw new NoSuchElementException("Очередь пуста");
        }
        char ch = queue[getLocation++];
        if (getLocation == queue.length) getLocation = 0; // Закольцевать
        return ch;
    }
}
