package CharQueue;

public interface CharQueue {
    // Добавление символа в очередь
    void put(char ch);

    // Извлечь символ из очереди
    char get();

    // Сбросить очередь
    void reset();
}
