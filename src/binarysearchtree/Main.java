package binarysearchtree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        System.out.println("Root = " + myBST.root);
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println(myBST.root.left.right.value);

        System.out.println("My tree contains 27 " + myBST.rContains(27));
        System.out.println("My tree contains 52 " + myBST.rContains(52));
        System.out.println("My tree contains 82 " + myBST.rContains(82));
        System.out.println("My tree contains 11 " + myBST.rContains(11));
        System.out.println("My tree contains 96 " + myBST.rContains(96));
        System.out.println();

        myBST.insert(96);
        System.out.println("My tree contains 96 " + myBST.rContains(96));

        BinarySearchTree myBST2 = new BinarySearchTree();
        myBST2.rInsert(2);
        myBST2.rInsert(1);
        myBST2.rInsert(3);

        System.out.println("\nRoot: " +  myBST2.root.value);
        System.out.println("Root->Left: " +  myBST2.root.left.value);
        System.out.println("Root->Right: " +  myBST2.root.right.value);

        myBST2.deleteNode(2);
        System.out.println("\nRoot: " +  myBST2.root.value);
        System.out.println("Root->Left: " +  myBST2.root.left.value);
        System.out.println("Root->Right: " +  myBST2.root.right);

        System.out.println(myBST.lowestCommonAncestor(myBST.root, 10 , 11).value);

    }
}
