package doublelinkedlist;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList myDLL = new DoubleLinkedList(7);
        myDLL.append(8);
        myDLL.prepend(6);
        myDLL.prepend(5);
        myDLL.append(9);
        myDLL.printList();
        System.out.println();

        System.out.println(myDLL.get(2).value);
    }
}
