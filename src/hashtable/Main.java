package hashtable;

import java.util.HashMap;

public class Main {

    public static boolean itemInCommon(int[] array1, int [] array2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : array1) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            }
        }
        for (int j : array2) {
            if (map.containsKey(j)) {
                return true;
            }
        }
        return false;
    }

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
        System.out.println();

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
    }
}
