package hashtable;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("nails", 100);
        hashTable.set("tile", 50);
        hashTable.set("lumber", 80);

        hashTable.set("bolts", 200);
        hashTable.set("screws", 140);
        hashTable.set("bulbs", 100);
        hashTable.set("scissors", 150);

        hashTable.printTable();
        System.out.println();

        System.out.println(hashTable.get("bolts"));
        System.out.println(hashTable.get("tile"));
        System.out.println(hashTable.get("turners"));
        System.out.println();

        System.out.println(hashTable.keys());
    }
}
