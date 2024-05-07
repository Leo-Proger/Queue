package IntegerQueue;

public interface IntegerQueue {
    // Добавление числа в очередь
    void put(int ch);

    // Извлечь число из очереди
    int get();

    // Сбросить очередь
    void reset();
}
