// aim of this code is to test the implementation for convertToPostfix.java

import java.util.*;

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

  public static int applyOperator(char operator, int op1, int op2) {
    switch (operator) {
      case '+': return op1 + op2;
      case '-': return op1 - op2;
      case '*': return op1 * op2;
      case '/': 
        if (op2 == 0) return 0; 
        return op1 / op2;
      default: 
        return 0; 
    }
  }

  public static int evaluatePostfix(String postfix, Map<Character, Integer> variables) {
      ResizeableArrayStack<Integer> stack = new ResizeableArrayStack<>(); 

      String[] tokens = postfix.split("\\s+");

      for (String token : tokens) {
        if (token.length() == 1 && Character.isLetter(token.charAt(0))) {
          char var = token.charAt(0); 
          if (variables.containsKey(var)) {
            stack.push(variables.get(var)); 
          }
        }
        else if (token.length() == 1 && "+-*/".indexOf(token.charAt(0)) != -1) {
          int operand2 = stack.pop(); 
          int operand1 = stack.pop(); 
          char operator = token.charAt(0);
          int result = applyOperator(operator, operand1, operand2);
          stack.push(result); 
        }
        else {
          stack.push(Integer.parseInt(token));
        }
      }
      return stack.pop(); 
  }

}
