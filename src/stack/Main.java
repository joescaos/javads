package stack;

public class Main {

    public static String reverseString(String s) {
        StackGeneric<Character> stack = new StackGeneric<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        /*Stack stack = new Stack(5);

        stack.push(4);
        stack.push(6);
        stack.printStack();
        stack.getTop();
        stack.getHeight();

        System.out.println();
        System.out.println(stack.pop().value);
        System.out.println();
        stack.printStack();*/

        StackGeneric<Integer> stackGeneric = new StackGeneric<>();
        stackGeneric.push(1);
        stackGeneric.push(2);
        stackGeneric.push(3);
        stackGeneric.printStack();
        System.out.println("element pop: " + stackGeneric.pop());
        System.out.println();
        stackGeneric.printStack();

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);
    }
}
