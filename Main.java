import java.util.*;

public class Main {
  public static void main(String[] args) {
    String infix = "a*b/(c-a)+d*e"; 
    String postfix = Calculator.convertToPostfix(infix);
    System.out.println("Infix Expression: " + infix); 
    System.out.println("Postfix Expression: " + postfix);

    Map<Character, Integer> variables = new HashMap<>(); 
    variables.put('a', 2);
    variables.put('b', 3);
    variables.put('c', 4);
    variables.put('d', 5);
    variables.put('e', 6); 

    int result = Calculator.evaluatePostfix(postfix, variables);
    System.out.println("Evaluation Result: " + result); 
  }
}