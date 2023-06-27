package trie;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("alabama");
        trie.insert("algorithm");
        trie.insert("barbecue");
        trie.insert("barcode");
        trie.insert("aluminum");
        trie.insert("ajax");


        System.out.println(trie.search("alabama"));
        System.out.println(trie.startsWith("al"));

        System.out.println(trie.search("altobravo"));
        System.out.println(trie.startsWith("dyn"));
    }
}
