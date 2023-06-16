package queue;

public class Main {

    public static void main(String[] args) {
        /*Queue queue = new Queue(7);
        queue.printQueue();
        System.out.println();

        queue.enqueue(8);
        queue.enqueue(9);
        queue.printQueue();
        System.out.println();

        System.out.println("node removed " + queue.dequeue().value);
        System.out.println("node removed " + queue.dequeue().value);
        System.out.println("node removed " + queue.dequeue().value);
        System.out.println("node removed " + queue.dequeue());
        queue.printQueue();*/

        MyQueue stackQueue = new MyQueue();

        stackQueue.enqueue(1);
        stackQueue.enqueue(2);
        stackQueue.enqueue(3);
        System.out.println(stackQueue.peek());

        System.out.println();
        Integer front = stackQueue.dequeue();
        System.out.println(front);
        System.out.println(stackQueue.peek());

    }
}
