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

    public static boolean isBalancedParentheses(String s) {
        StackGeneric<Character> stack = new StackGeneric<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || stack.pop() != '(') {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static  void sortStack(StackGeneric<Integer> stackGeneric) {
        StackGeneric<Integer> additionalStack = new StackGeneric<>();
        while (!stackGeneric.isEmpty()) {
            Integer temp = stackGeneric.pop();
            while (!additionalStack.isEmpty() && (additionalStack.peek() > temp)) {
                stackGeneric.push(additionalStack.pop());

            }
            additionalStack.push(temp);
        }
        while (!additionalStack.isEmpty()) {
            stackGeneric.push(additionalStack.pop());
        }
    }

    private static final char [][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static boolean isBalanced(String s) {
        StackGeneric<Character> charStack = new StackGeneric<>();
        for (char c: s.toCharArray()) {
            if (isOpenTerm(c)) {
                charStack.push(c);
            } else {
                if (charStack.isEmpty() || !matches(charStack.pop(), c)) {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
    private static boolean matches(char openTerm, char closeTerm) {
        for (char[] chars: TOKENS) {
            if (chars[0] == openTerm) return chars[1] == closeTerm;
        }
        return false;
    }
    private static boolean isOpenTerm(char c) {
        for (char[] chars: TOKENS) {
            if (chars[0] == c) return true;
        }
        return false;
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

        /*String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);*/
        System.out.println(isBalancedParentheses("()()()"));

        StackGeneric<Integer> stack = new StackGeneric<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

        System.out.println(isBalanced("{[(]}"));


    }

}
