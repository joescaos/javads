package linkedlist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedList {

    private Node head;

    private Node tail;

    private int length;

    class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (Objects.nonNull(temp)) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head:" + head.value);
        ;
    }

    public void getTail() {
        System.out.println("Tail:" + tail.value);
        ;
    }

    public void getLength() {
        System.out.println("Length:" + length);
        ;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (Objects.isNull(head) && Objects.isNull(tail)) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) removeLast();
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node next;
        Node prev = null;
        for (int i = 0; i < length; i++) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }

    public Node findMiddleNode() {
        if (head == null) return null;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k) {

        Node fast = head;
        Node slow = head;

        int count = 0;

        while (fast != null) {
            if (count == k) break;
            count++;
            fast = fast.next;
        }

        if (count == k) {
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        } else {
            return null;
        }
    }

    public void reverseBetween(int m, int n) {
        if (head == null) return;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }
        Node current = prev.next;
        for (int i = 0; i < n - m; i++) {
            Node after = current.next;
            current.next = after.next;
            after.next = prev.next;
            prev.next = after;
        }
        head = dummy.next;
    }

    public void partitionList(int x) {
        Node left = new Node(0);
        Node right = new Node(0);

        Node leftTail = left;
        Node rightTail = right;

        while (head != null) {
            if (head.value < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }

        leftTail.next = right.next;
        rightTail.next = null;
        head = left.next;
    }

    public void removeDuplicates() {
        Set<Integer> valuesSet = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            int currentVal = current.value;
            if (valuesSet.contains(currentVal)) {
                prev.next = current.next;
                length--;
            } else {
                valuesSet.add(currentVal);
                prev = current;
            }
            current = current.next;
        }
    }

    public void insertionSort() {
        if (length < 2) {
            return;
        }

        Node sortedListHead = head;
        Node unsortedListHead = head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (current.value < sortedListHead.value) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next != null && current.value > searchPointer.next.value) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }


}
