package IntegerQueue.DynamicQueue;

import IntegerQueue.IntegerQueue;

public class Main {
    public static void main(String[] args) {
        IntegerQueue queue = new Queue(3);

        queue.put(3);
        queue.put(4);
        queue.put(5);

        System.out.println(queue.get()); // 3
        System.out.println(queue.get()); // 4
        System.out.println(queue.get()); // 5

        queue.put(6);

        System.out.println(queue.get()); // 6
    }
}
