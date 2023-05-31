package stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(4);
        stack.push(6);
        stack.printStack();
        stack.getTop();
        stack.getHeight();

        System.out.println();
        System.out.println(stack.pop().value);
        System.out.println();
        stack.printStack();
    }
}
