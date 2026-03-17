
//Expression check
class StackChar {
    private char[] stack;
    private int top;
    private int size;

    public StackChar(int size) {
        stack = new char[size];
        this.size = size;
        top = -1;
    }

    public void push(char data) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = data;
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack UnderFlow");
            return '0';
        }
        return stack[top--];
    }

    public char peek() {
        return stack[top];
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack UnderFlow");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}

public class ExpressionCheck {
    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String expression = "{[()]}";
        StackChar stack = new StackChar(expression.length());
        boolean isBalanced = true;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') { 
                char last = stack.pop();
                
                if (!isMatching(last, ch)) {
                    isBalanced = false;
                    break;
                }
            }
            if (isBalanced && stack.pop() == '0') {
                System.out.println("valid Expression");
            } else {
                System.out.println("Invalid Expression");
            }
        }
    }
}
