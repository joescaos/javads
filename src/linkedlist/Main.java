package linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);

        linkedList.prepend(5);
        linkedList.prepend(6);

        linkedList.printList();

        System.out.println("node removed: " + linkedList.removeFirst().value);
        linkedList.append(9);
        System.out.println();
        linkedList.printList();
        System.out.println();

        linkedList.set(2, 10);
        linkedList.printList();
        System.out.println();

        linkedList.insert(1, 1);
        linkedList.printList();
        System.out.println();

        System.out.println(linkedList.remove(2).value);
        linkedList.append(45);
        linkedList.printList();
        System.out.println();

        linkedList.reverse();

        linkedList.printList();

    }
}
