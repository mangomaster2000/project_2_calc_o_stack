// aim of this code is to test the implementation for convertToPostfix.java

public class Calculator {
  public static String convertToPostfix(String infix) {
    LinkedStack<Character> stack = new LinkedStack<>();
    StringBuilder postfix = new StringBuilder();
    String operators = "+-*/()";

    for (int i = 0; i < infix.length(); i++) {
      char symbol = infix.charAt(i);

      if (Character.isLetterOrDigit(symbol)) {
        postfix.append(symbol).append(' ');
      } else if (symbol == '(') {
        stack.push(symbol);
      } else if (symbol == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          postfix.append(stack.pop()).append(' ');
        }
        stack.pop(); 
      } else if (operators.indexOf(symbol) != -1) {
        while (!stack.isEmpty() && stack.peek() != '(' && precede(stack.peek()) >= precede(symbol)) {
          postfix.append(stack.pop()).append(' ');
        }
        stack.push(symbol);
      }
    }

    while (!stack.isEmpty()) {
      postfix.append(stack.pop()).append(' ');
    }

    return postfix.toString().trim();
  }

  public static int precede(char operator) {
    switch (operator) {
      case '+': case '-' : return 1;
      case '*': case '/' : return 2;
      default: return 0;
    }
  }
}
