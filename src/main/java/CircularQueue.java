import java.util.NoSuchElementException;

public class CircularQueue implements Queue {
    public final int size;

    private int[] queue;
    private int putLocation, getLocation;

    // Создает очередь с заданным размером
    public CircularQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Размер очереди не может быть отрицательным");
        }
        this.size = size;
        queue = new int[size + 1];
        putLocation = getLocation = 0;
    }

    // Добавить символ в очередь
    public void put(int value) {
        /* Очередь переполнена, если putLocation на единицу меньше getLocation или
        putLocation указывает на конец массива, а getLocation - на его начало */
        if (putLocation + 1 == getLocation || ((putLocation == queue.length - 1) && (getLocation == 0))) {
            throw new ArrayIndexOutOfBoundsException("Очередь переполнена");
        }
        queue[putLocation++] = value;
        if (putLocation == queue.length) putLocation = 0; // Закольцевать
    }

    // Прочитать символ очереди
    public int get() {
        if (getLocation == putLocation) {
            throw new NoSuchElementException("Очередь пуста");
        }
        int value = queue[getLocation];
        queue[getLocation++] = 0;
        if (getLocation == queue.length) getLocation = 0; // Закольцевать
        return value;
    }

    public void reset() {
        queue = new int[size + 1];
        getLocation = putLocation = 0;
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
}
