package IntegerQueue.CircularQueue;


import IntegerQueue.IntegerQueue;

public class Main {
    public static void main(String[] args) {
        IntegerQueue queue = new Queue(3);

        queue.put(5);
        queue.put(6);
        queue.put(7);

        System.out.println(queue.get()); // 5
        System.out.println(queue.get()); // 6

        queue.put(8);

        System.out.println(queue.get()); // 7
        System.out.println(queue.get()); // 8
    }
}
