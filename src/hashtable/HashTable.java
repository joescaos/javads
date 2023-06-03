package hashtable;

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
}
