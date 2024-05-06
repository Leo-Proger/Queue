package FixedQueue.IntegerQueue;

public class Main {
    public static void main(String[] args) {
        // Пример 1
        Queue queue1 = new Queue(3);

        queue1.put(1);
        queue1.put(2);
        queue1.put(3);

        for (int i = 0; i < queue1.size; i++) {
            System.out.println(queue1.get());
        }
        System.out.println();

        // Пример 2
        Queue queue2 = new Queue(3);

        queue2.put(4);
        queue2.put(5);
        queue2.put(6);

        Queue queue3 = new Queue(queue2);

        for (int i = 0; i < queue3.size; i++) {
            System.out.println(queue3.get());
        }
    }
}