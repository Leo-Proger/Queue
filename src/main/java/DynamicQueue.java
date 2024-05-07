import java.util.NoSuchElementException;

public class DynamicQueue implements Queue {
    public final int size;

    private int[] queue;

    private int putLocation = 0; // Индекс элемента очереди, по которому будет вставлен следующий элемент
    private int getLocation = 0; // Индекс элемента очереди, который будет возвращен при чтении

    public DynamicQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Размер очереди не может быть отрицательным");
        }
        this.size = size;
        queue = new int[size];
    }

    public DynamicQueue(DynamicQueue q) {
        this.size = q.size;
        this.queue = new int[size];
        this.getLocation = q.getLocation;
        this.putLocation = q.putLocation;

        System.arraycopy(q.queue, 0, queue, 0, q.putLocation);
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
        putLocation = getLocation = 0;
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
