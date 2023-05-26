package linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(4);


        linkedList.getHead();
        linkedList.getTail();
        linkedList.getLength();

        linkedList.printList();

        linkedList.append(6);
        linkedList.append(9);
        System.out.println();

        linkedList.printList();
        System.out.println();

        System.out.println("This is the node value removed = " + linkedList.removeLast().value);
        linkedList.printList();
        System.out.println();

        LinkedList oneElementLinkedList = new LinkedList(3);
        System.out.println(oneElementLinkedList.removeLast().value);
        System.out.println(oneElementLinkedList.removeLast());
        oneElementLinkedList.getLength();

    }
}
