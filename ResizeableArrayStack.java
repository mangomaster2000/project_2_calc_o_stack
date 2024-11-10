import java.util.*;

public class ResizeableArrayStack<T> implements StackInterface<T> {
  private T[] stack; 
  private int topIndex; 
  private static final int DEFAULT_CAPACITY = 10;

  public ResizeableArrayStack() {
    stack = (T[]) new Object[DEFAULT_CAPACITY];
    topIndex = -1;
  }

  @Override
  public void push(T newEntry) {
    if (topIndex + 1 == stack.length) {
      doubleCapacity(); 
    }
    stack[++topIndex] = newEntry; 
  }

  @Override
  public T pop() {
    T top = stack[topIndex]; 
    stack[topIndex--] = null; 
    return top; 
  }

  @Override
  public T peek() {
    return stack[topIndex]; 
  }
  
  @Override
  public boolean isEmpty() {
    return topIndex < 0; 
  }
      

  private void doubleCapacity() {
    stack = Arrays.copyOf(stack, 2 * stack.length); 
  }

}