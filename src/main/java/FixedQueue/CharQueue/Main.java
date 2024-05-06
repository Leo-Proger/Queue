package FixedQueue.CharQueue;

public class Main {
    public static void main(String[] args) {
        // Пример 1
        Queue queue1 = new Queue(3);

        queue1.put('a');
        queue1.put('b');
        queue1.put('c');

        for (int i = 0; i < queue1.size; i++) {
            System.out.println(queue1.get());
        }
        System.out.println();

        // Пример 2
        Queue queue2 = new Queue(3);

        queue2.put('d');
        queue2.put('e');
        queue2.put('f');

        Queue queue3 = new Queue(queue2);

        for (int i = 0; i < queue3.size; i++) {
            System.out.println(queue3.get());
        }
    }
}
