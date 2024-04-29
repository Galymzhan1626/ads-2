import java.util.Iterator;

public class MyStack<E>{
    private class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> top;
    private int size;
    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public E pop() {
        if (size==0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        E poppedItem = top.data;
        top = top.next;
        size--;
        return poppedItem;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int size() {
        return size;
    }
}
