package queue;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue(7);
        queue.printQueue();
        queue.getFirst();
        queue.getLast();
    }
}
