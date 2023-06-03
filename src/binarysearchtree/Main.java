package binarysearchtree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        System.out.println("Root = " + myBST.root);
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(52);
        myBST.insert(82);

        myBST.insert(27);

        System.out.println(myBST.root.left.right.value);

        System.out.println("My tree contains 27 " + myBST.contains(27));
        System.out.println("My tree contains 52 " + myBST.contains(52));
        System.out.println("My tree contains 82 " + myBST.contains(82));
        System.out.println("My tree contains 11 " + myBST.contains(11));
        System.out.println("My tree contains 96 " + myBST.contains(96));
        System.out.println();

        myBST.insert(96);
        System.out.println("My tree contains 96 " + myBST.contains(96));

    }
}
