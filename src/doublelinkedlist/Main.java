package doublelinkedlist;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList myDLL = new DoubleLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);
        myDLL.append(6);
        myDLL.append(7);
        myDLL.append(8);
        myDLL.printList();
        System.out.println();

        /*myDLL.set(2, 4);
        myDLL.printList();

        System.out.println();
        myDLL.insert(3, 5);
        myDLL.printList();

        System.out.println("Node removed" + myDLL.remove(3).value);
        System.out.println();
        myDLL.printList();*/
        //System.out.println(myDLL.isPalindrome());;
        myDLL.swapPairs();
        myDLL.printList();

    }
}
