package CharQueue.CircularQueue;

import CharQueue.CharQueue;

public class Main {
    public static void main(String[] args) {
        CharQueue queue = new Queue(3);

        queue.put('a');
        queue.put('b');
        queue.put('c');

        System.out.println(queue.get()); // a
        System.out.println(queue.get()); // b

        queue.put('d');

        System.out.println(queue.get()); // c
        System.out.println(queue.get()); // d
    }
}
