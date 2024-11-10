// LinkedStack class implementation

public class LinkedStack<T> implements StackInterface<T> {
  private Node<T> top; 

  private static class Node<T> {
    T data; 
    Node<T> next;

    Node(T data) {
      this.data = data;
    }
  }

  public LinkedStack() {
    top = null; 
  }

  @Override
  public void push (T newEntry) {
    Node<T> newNode = new Node<T>(newEntry);
    newNode.next = top;
    top = newNode;
  }

  @Override
  public T pop() {
    T result = top.data; 
    top = top.next; 
    return result; 
  }

  @Override
  public T peek() {
    return top.data; 
  }

  @Override
  public boolean isEmpty() {
    return top == null; 
  }
}