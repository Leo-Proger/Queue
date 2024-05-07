import java.util.NoSuchElementException;

public class FixedQueue implements Queue {
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
        this.count = q.count;

        System.arraycopy(q.queue, 0, queue, 0, q.putLocation);
    }

    public CircularQueue toCircularQueue(FixedQueue q) {
        CircularQueue circularQueue = new CircularQueue(size);

        for (int i = 0; i < q.size; i++) {
            circularQueue.put(q.get());
        }
        return circularQueue;
    }

    public DynamicQueue toDynamicQueue(FixedQueue q) {
        DynamicQueue dynamicQueue = new DynamicQueue(size);

        for (int i = 0; i < q.getCount(); i++) {
            dynamicQueue.put(q.queue[q.getLocation + i]);
        }
        return dynamicQueue;
    }

    // Вставка элемента в конец очереди
    public void put(int value) {
        if (count >= size || putLocation == size) {
            throw new ArrayIndexOutOfBoundsException("Очередь переполнена");
        }
        queue[putLocation++] = value;
        count++;
    }

    // Прочитать элемент очереди
    public int get() {
        if (count == 0 || getLocation == size) {
            throw new NoSuchElementException("В очереди нет элементов");
        }
        int value = queue[getLocation];
        queue[getLocation++] = 0;
        count--;
        return value;
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
