package linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1);
        myList.append(4);
        myList.append(3);
        myList.append(2);
        myList.append(5);
        myList.append(5);
        myList.append(5);
        myList.append(2);

        //System.out.println(myList.findMiddleNode().value);

        /*myList.append(6);
        System.out.println(myList.findMiddleNode().value);*/

        /*myList.append(7);
        myList.append(8);*/
        //System.out.println(myList.findMiddleNode().value);
        //myList.printList();

        //System.out.println("\n" + myList.findKthFromEnd(10));
        /*myList.reverseBetween(1, 3);*/
        myList.printList();

        //myList.partitionList(3);

        myList.removeDuplicates();
        System.out.println();
        myList.printList();


    }
}
