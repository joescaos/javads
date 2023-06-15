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

    public static boolean isBalancedParentheses(String parentheses) {
        // Create an empty stack of characters
        StackGeneric<Character> stack = new StackGeneric<>();

        // Iterate through each character in the input string
        for (char p : parentheses.toCharArray()) {
            // If the current character is an opening parenthesis, push it onto the stack
            if (p == '(') {
                stack.push(p);
            }
            // If the current character is a closing parenthesis, check if the stack is empty or
            // if the top element of the stack is not an opening parenthesis. If either of these
            // conditions is true, return false, because the parentheses are not balanced.
            else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        // After iterating through all the characters in the input string, check if the stack is
        // empty. If the stack is empty, return true, because all the opening parentheses have been
        // matched with closing parentheses. Otherwise, return false, because there are still some
        // opening parentheses left on the stack that have not been matched with closing parentheses.
        return stack.isEmpty();
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
        System.out.println(isBalancedParentheses("())()"));
    }
}
