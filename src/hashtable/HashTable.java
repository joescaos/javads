package hashtable;

import java.util.ArrayList;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        this.dataMap = new Node[size];
    }


    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("{" + temp.key + "=" + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        return key.hashCode() % dataMap.length;
    }

    public void set(String key, int value) {
        int index = Math.abs(hash(key));
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = Math.abs(key.hashCode() % dataMap.length);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keysList = new ArrayList<>();
        for (Node node : dataMap) {
            Node temp = node;
            while (temp != null) {
                keysList.add(temp.key);
                temp = temp.next;
            }
        }
        return keysList;
    }
}
